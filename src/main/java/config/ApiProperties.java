package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

/**
 * Интерфейс для доступа к глобальным переменным проперти
 */
@LoadPolicy(LoadType.MERGE)
@Sources({"file:src/test/resources/api.properties"})
public interface ApiProperties extends Config{

    /**
     * метод возвращает url списка пользователей сервиса
     * @return строка
     */
    @Key("get.users.list.url")
    String getUsersListUrl();

    /**
     * ьутод возвращает url авторизации в сервисе
     * @return строка
     */
    @Key("login.url")
    String loginUrl();

    /**
     * метод возвращает url списка hex цвета
     * @return строка
     */
    @Key("get.resource.list.url")
    String getResourceUrl();

    /**
     * метод возвращает url страницы для подсчета тегов
     * @return строка
     */
    @Key("tag.count.url")
    String tagCountUrl();

    /**
     * метод возвращает числовой статус запроса
     * @return число
     */
    @Key("status.ok")
    int statusOk();

    /**
     * метод возвращает числовой статус запроса
     * @return число
     */
    @Key("status.bad.request")
    int statusBadRequest();

    /**
     * метод возвращает количество искомых тегов
     * @return число
     */
    @Key("tag.count")
    int tagCount();
}