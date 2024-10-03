package config;

import org.aeonbits.owner.ConfigFactory;

/**
 * Класс управления глобальными настройками (пропертями)
 */
public class Properties {

    /**
     * переменная доступа к интерфейсу для проперти
     */
    public static ApiProperties apiProperties = ConfigFactory.create(ApiProperties.class);

    /**
     * переменная доступа к интерфейсу для проперти
     */
    public static ApiRequestProperties apiRequestProperties = ConfigFactory.create(ApiRequestProperties.class);

    /**
     * переменная доступа к интерфейсу для проперти
     */
    public static ApiResponseProperties apiResponseProperties = ConfigFactory.create(ApiResponseProperties.class);

    /**
     * переменная доступа к интерфейсу для проперти
     */
    public static UnitProperties unitProperties = ConfigFactory.create(UnitProperties.class);
}