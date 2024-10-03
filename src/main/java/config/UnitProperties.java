package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс для доступа к глобальным переменным проперти
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:src/test/resources/unit.properties"})
public interface UnitProperties extends Config{

    /**
     * метод возвращает путь к файлу
     * @return строка
     */
    @Config.Key("valid.testdata.json.path")
    String testDataJsonPath();

    /**
     * метод возвращает путь к файлу
     * @return строка
     */
    @Key("file.name.avatar.empty")
    String fileNameAvatarEmpty();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Config.Key("file.name.avatar.valid")
    String validNameAvatarJson();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Config.Key("file.name.avatar.invalid")
    String invalidNameAvatarJson();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Key("token.valid")
    String tokenValid();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Key("token.invalid")
    String tokenInvalid();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Key("token.empty")
    String tokenEmpty();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Key("error.valid")
    String errorValid();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Key("error.invalid")
    String errorInvalid();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Key("error.empty")
    String errorEmpty();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Key("sorted.data.valid")
    String sortedDataValid();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Key("sorted.data.invalid")
    String sortedDataInvalid();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Key("sorted.data.empty")
    String sortedDataEmpty();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Key("count.tags.valid")
    String countTagsValid();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Key("count.tags.less")
    String countTagsLess();

    /**
     * метод возвращает имя файла
     * @return строка
     */
    @Key("count.tags.more")
    String countTagsMore();
}