package dto.authorization;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс отображает json в объект java
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthorizationResponse {

    /**
     * текст токена
     */
    private String token;

    /**
     * текст ошибки
     */
    private String error;
}