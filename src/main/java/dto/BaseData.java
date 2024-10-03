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
public class BaseData {

    /**
     * номер объекта
     */
    private Integer id;

}