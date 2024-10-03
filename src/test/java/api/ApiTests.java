package api;

import dto.authorization.AuthorizationRequest;
import dto.get.name.avatar.AvatarData;
import dto.get.name.avatar.AvatarResponseJson;
import dto.authorization.AuthorizationResponse;
import dto.list.resource.ResourceData;
import dto.list.resource.ResourceResponseJson;
import io.restassured.response.ValidatableResponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static config.Properties.apiRequestProperties;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specification.Specification.*;

public class ApiTests {

    @ParameterizedTest(name = "{displayName}: {arguments}")
    @DisplayName("Уникальность имени файла аватара")
    @MethodSource("helpers.DataProvider#providerGetListAvatarName")
    public void getUserListTest() {
        installSpec(requestSpec(), responseSpec200());

        List<AvatarData> data = given()
                .when()
                .get()
                .then()
                .log().body()
                .extract().body().as(AvatarResponseJson.class)
                .getData();
        deleteSpec();

        List<String> collect = data.stream()
                .map(AvatarData::getAvatar)
                .map(e -> {
                    String fileName = e.substring(e.lastIndexOf('/') + 1);
                    return fileName.substring(0, fileName.lastIndexOf('.'));
                })
                .collect(Collectors.groupingBy(
                        item -> item,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        assertTrue(data.size() > 0, "В списке не найдено записей");
        assertTrue(collect.size() == 0,
                "имена файлов аватаров пользователей не уникальны, есть повтор по " + collect);
    }

    @ParameterizedTest(name = "{displayName}: {arguments}")
    @DisplayName("Авторизация в системе")
    @MethodSource("helpers.DataProvider#providerPositiveAuthorizationData")
    public void authorizationPositiveTest(String url, AuthorizationRequest login, String expectedResponse, int status,
                                          String scenario) {
        AuthorizationResponse as = given()
                .contentType("application/json")
                .body(login)
                .when()
                .post(url)
                .then()
                .log().body()
                .statusCode(status)
                .extract().body().as(AuthorizationResponse.class);

        String responseToken = null;
        if (scenario.equals(apiRequestProperties.positiveScenario())) {
            responseToken = as.getToken();
        }
        if (scenario.equals(apiRequestProperties.negativeScenario())) {
            responseToken = as.getError();
        }
        assertEquals(expectedResponse, responseToken,
                "Фактический " + expectedResponse + " не совпадает с ожидаемым " + responseToken + " результатом");
    }

    @ParameterizedTest(name = "{displayName}: {arguments}")
    @DisplayName("Отсортированные данные годов")
    @MethodSource("helpers.DataProvider#providerGetListResourceData")
    public void sortedDataTest(String url, int status) {
        List<ResourceData> data = given()
                .when()
                .get(url)
                .then()
                .log().body()
                .statusCode(status)
                .extract().body().as(ResourceResponseJson.class)
                .getData();

        boolean sortedCheck = data.stream()
                .map(ResourceData::getYear)
                .sorted()
                .collect(Collectors.toList())
                .equals(data.stream()
                        .map(ResourceData::getYear)
                        .collect(Collectors.toList()));
        assertTrue(data.size() > 0, "В списке не найдено записей");
        assertTrue(sortedCheck, "Данные не отсортированы по годам");
    }

    @ParameterizedTest(name = "{displayName}: {arguments}")
    @DisplayName("Подсчет количества тегов")
    @MethodSource("helpers.DataProvider#providerGetTagsCountData")
    public void countTagsTest(String url, int countCheck) {
        ValidatableResponse xmlResponse = given()
                .when()
                .get(url)
                .then()
                .log().body();
        String tagsString = xmlResponse.extract().body().asString();

        long count = Pattern.compile("[<][?]?[a-z]+").matcher(tagsString).results().count();
        String conditionText = "равно ";
        if (count > countCheck) {
            conditionText = "больше ";
        } else if (count < countCheck) {
            conditionText = "меньше ";
        }
        assertTrue(count == countCheck, "Количество подсчитанных тегов " + conditionText + countCheck);
    }
}