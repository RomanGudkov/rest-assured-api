package helpers;

import config.Properties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

/**
 * Класс - утилита по работе с json
 */
public class JsonHelper {

    /**
     * Объект ObjectMapper
     */
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Корневой путь к пакету с файлами json
     */
    static String testDataJsonPath = Properties.unitProperties.testDataJsonPath();

    static {
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    }

    /**
     * Получение данных из json-файла
     * @param filePath - путь к файлу
     * @param clazz - тип класса
     * @return объект класса
     * @param <T> - тип класса
     */
    public static <T> T fromJSONFile(final String filePath, Class<T> clazz) {
        T data = null;
        try {
            data = mapper.readValue(new File(testDataJsonPath + "/" + filePath), clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}