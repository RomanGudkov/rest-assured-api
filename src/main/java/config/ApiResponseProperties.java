package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

/**
 * Интерфейс для доступа к глобальным переменным проперти
 */
@LoadPolicy(LoadType.MERGE)
@Sources({"file:src/test/resources/api.properties"})
public interface ApiResponseProperties extends Config {

    /**
     * метод возвращает сравниваемое значение токена
     * @return строка
     */
    @Key("token.response")
    String tokenResponse();

    /**
     * метод возвращаеи сравниваемое значение ошибки
     * @return строка
     */
    @Key("error.response")
    String errorResponse();
}