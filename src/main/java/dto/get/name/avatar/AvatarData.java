package dto.get.name.avatar;

import dto.BaseData;
import lombok.*;

/**
 * Класс отображает json в объект java
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvatarData extends BaseData {

    /**
     * почта
     */
    private String email;

    /**
     * имя
     */
    private String first_name;

    /**
     * фамилия
     */
    private String last_name;

    /**
     * имя файла
     */
    private String avatar;
}