package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Класс отображает json в объект java
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Support {

    /**
     * адрес url
     */
    private String url;

    /**
     * текстовое описание
     */
    private String text;
}