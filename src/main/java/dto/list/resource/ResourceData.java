package dto.list.resource;

import dto.BaseData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс отображает json в объект java
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceData extends BaseData {

    /**
     * название цвета
     */
    private String name;

    /**
     * год
     */
    private Integer year;

    /**
     * hex номер цвета
     */
    private String color;

    /**
     * номер в каталоге
     */
    private String pantone_value;
}