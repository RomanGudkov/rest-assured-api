package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

/**
 * Интерфейс для доступа к глобальным переменным проперти
 */
@LoadPolicy(LoadType.MERGE)
@Sources({"file:src/test/resources/api.properties"})
public interface ApiRequestProperties extends Config {

    /**
     * метод возвращает статус позитивности теста
     *
     * @return строка
     */
    @Key("positive.scenario")
    String positiveScenario();

    /**
     * метод возвращает email для позитивного сценария авторизации
     *
     * @return строка
     */
    @Key("email.positive.scenario")
    String emailPositiveScenario();

    /**
     * метод возвращает пароль для позитивного сценария авторизации
     *
     * @return строка
     */
    @Key("password.positive.scenario")
    String passwordPositiveScenario();

    /**
     * метод возвращает статус позитивности теста
     *
     * @return строка
     */
    @Key("negative.scenario")
    String negativeScenario();

    /**
     * метод возвращает  email для негативного сценария авторизации
     *
     * @return строка
     */
    @Key("email.negative.scenario")
    String emailNegativeScenario();
}