package dto.get.name.avatar;

import dto.BaseResponseJson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Класс отображает json в объект java
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvatarResponseJson extends BaseResponseJson {

    /**
     * список объектов
     */
    private List<AvatarData> data;


}