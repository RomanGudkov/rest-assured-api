package helpers;

import dto.authorization.AuthorizationRequest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static config.Properties.*;

/**
 * Класс параметризации UNIT тестов
 */
public class DataProvider {

    /**
     * метод возвращает тестовые параметры
     *
     * @return список строк
     */
    public static Stream<Arguments> providerGetListAvatarName() {
        return Stream.of(
                Arguments.of(apiProperties.getUsersListUrl(), apiProperties.statusOk())
        );
    }

    /**
     * метод возвращает набор параметров теста
     *
     * @return поток аргументов
     */
    public static Stream<Arguments> providerPositiveAuthorizationData() {

        return Stream.of(
                Arguments.of(apiProperties.loginUrl(), new AuthorizationRequest(apiRequestProperties.emailPositiveScenario(),
                                apiRequestProperties.passwordPositiveScenario()), apiResponseProperties.tokenResponse(), apiProperties.statusOk(),
                        apiRequestProperties.positiveScenario()),
                Arguments.of(apiProperties.loginUrl(), new AuthorizationRequest(apiRequestProperties.emailNegativeScenario()),
                        apiResponseProperties.errorResponse(), apiProperties.statusBadRequest(), apiRequestProperties.negativeScenario())
        );
    }

    /**
     * метод возвращает тестовые параметры
     *
     * @return список строк
     */
    public static Stream<Arguments> providerGetListResourceData() {
        return Stream.of(
                Arguments.of(apiProperties.getResourceUrl(), apiProperties.statusOk())
        );
    }

    /**
     * метод возвращает тестовые параметры
     *
     * @return список строк
     */
    public static Stream<Arguments> providerGetTagsCountData() {
        return Stream.of(
                Arguments.of(apiProperties.tagCountUrl(), apiProperties.tagCount())
        );
    }
}