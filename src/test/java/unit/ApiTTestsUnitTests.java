package unit;

import dto.authorization.AuthorizationResponse;
import dto.get.name.avatar.AvatarData;
import dto.get.name.avatar.AvatarResponseJson;
import dto.list.resource.ResourceData;
import dto.list.resource.ResourceResponseJson;
import helpers.JsonHelper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static config.Properties.apiRequestProperties;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTTestsUnitTests {

    @ParameterizedTest(name = "{displayName}: {arguments}")
    @DisplayName("Тестируем тест уникальности имени файла аватара")
    @MethodSource("helpers.DataProviderUnit#providerAvatarData")
    public void getUserListTestUnitTest(String jsonPath) {
        AvatarResponseJson validList = JsonHelper.fromJSONFile(jsonPath, AvatarResponseJson.class);
        List<AvatarData> data = validList.getData();

        List<String> collectRight = data.stream()
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
        assertTrue(collectRight.size() == 0,
                "имена файлов аватаров пользователей не уникальны, есть повтор по " + collectRight);
    }

    @ParameterizedTest(name = "{displayName}: {arguments}")
    @DisplayName("Тестируем тест авторизации в системе")
    @MethodSource("helpers.DataProviderUnit#providerAuthorizationData")
    public void authorizationPositiveTestUnitTest(String jsonPath, String expectedResponse, String scenario) {
        AuthorizationResponse as = JsonHelper.fromJSONFile(jsonPath, AuthorizationResponse.class);

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
    @DisplayName("Тестируем тест отсортированных данных годов")
    @MethodSource("helpers.DataProviderUnit#providerSortedDataData")
    public void sortedDataTestUnitTest(String jsonPath) {
        ResourceResponseJson validList = JsonHelper.fromJSONFile(jsonPath, ResourceResponseJson.class);
        List<ResourceData> data = validList.getData();

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

    @SneakyThrows
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @DisplayName("Тестируем тест подсчета количества тегов")
    @MethodSource("helpers.DataProviderUnit#providerCountTagsData")
    public void countTagsTestUnitTest(String tagsPath, int countCheck) {
        String tagsString = new String(Files.readAllBytes(Paths.get(tagsPath)));
        long count = Pattern.compile("[<][?]?[a-z]+").matcher(tagsString).results().count();
        String conditionText = "равно ";
        if (count > countCheck) {
            conditionText = "больше ";
        } else if (count < countCheck) {
            conditionText = "меньше ";
        }
        assertTrue(count == countCheck, "Количество тегов в документе " + conditionText + countCheck);
    }
}