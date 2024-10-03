package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Базовый класс отображает json в объект java
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseJson {

    /**
     * номер страницы
     */
    private Integer page;

    /**
     * количества результатов на странице
     */
    private Integer per_page;

    /**
     * общее количества записей
     */
    private Integer total;

    /**
     * общее количество страниц
     */
    private Integer total_pages;

    /**
     * объект поддержки
     */
    private Support support;
}