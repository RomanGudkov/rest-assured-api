package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static config.Properties.*;
import static config.Properties.apiRequestProperties;

/**
 * Класс параметризации API тестов
 */
public class DataProviderUnit {

    /**
     * метод возвращает зазвание файла
     *
     * @return список строк
     */
    public static List<String> providerAvatarData() {

        return Arrays.asList(
                unitProperties.validNameAvatarJson(), unitProperties.invalidNameAvatarJson(), unitProperties.fileNameAvatarEmpty()
        );
    }

    /**
     * метод возвращает набор параметров теста
     *
     * @return набор параметров
     */
    public static Stream<Arguments> providerAuthorizationData() {

        return Stream.of(
                Arguments.of(unitProperties.tokenValid(), apiResponseProperties.tokenResponse(),
                        apiRequestProperties.positiveScenario()),
                Arguments.of(unitProperties.tokenInvalid(), apiResponseProperties.tokenResponse(),
                        apiRequestProperties.positiveScenario()),
                Arguments.of(unitProperties.tokenEmpty(), apiResponseProperties.tokenResponse(),
                        apiRequestProperties.positiveScenario()),
                Arguments.of(unitProperties.errorValid(), apiResponseProperties.errorResponse(),
                        apiRequestProperties.negativeScenario()),
                Arguments.of(unitProperties.errorInvalid(), apiResponseProperties.errorResponse(),
                        apiRequestProperties.negativeScenario()),
                Arguments.of(unitProperties.errorEmpty(), apiResponseProperties.errorResponse(),
                        apiRequestProperties.negativeScenario())
        );
    }

    /**
     * метод возвращает зазвание файла
     *
     * @return список строк
     */
    public static List<String> providerSortedDataData() {

        return Arrays.asList(unitProperties.sortedDataValid(), unitProperties.sortedDataInvalid(),
                unitProperties.sortedDataEmpty());
    }

    /**
     * метод возвращает набор параметров теста
     *
     * @return набор параметров
     */
    public static Stream<Arguments> providerCountTagsData() {
        String path = unitProperties.testDataJsonPath() + "/";

        return Stream.of(
                Arguments.of(path + unitProperties.countTagsValid(), apiProperties.tagCount()),
                Arguments.of(path + unitProperties.countTagsLess(), apiProperties.tagCount()),
                Arguments.of(path + unitProperties.countTagsMore(), apiProperties.tagCount())
        );
    }
}