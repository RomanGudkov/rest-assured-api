package specification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static config.Properties.apiProperties;

/**
 * Класс настройки ответов API
 */
public class Specification {

    /**
     * метод создает преднастройки параметров запроса
     *
     * @return параметры запроса
     */
    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(apiProperties.getUsersListUrl())
                .build();
    }

    /**
     * метод создает преднастройки параметров ответа
     *
     * @return параметры ответа
     */
    public static ResponseSpecification responseSpec200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(apiProperties.statusOk())
                .build();
    }

    /**
     * метод возвращает настройки параметров API
     * @param requestSpec параметр запроса
     * @param responseSpec параметр ответа
     */
    public static void installSpec(RequestSpecification requestSpec, ResponseSpecification responseSpec) {
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }

    /**
     * метод удаляет настройки параметров API
     */
    public static void deleteSpec() {
        RestAssured.requestSpecification = null;
        RestAssured.responseSpecification = null;
    }
}