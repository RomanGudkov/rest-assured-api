package dto.authorization;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Класс отображает json в объект java
 */
@Getter
@NoArgsConstructor
public class AuthorizationRequest {

    /**
     * адрес эл. почты
     */
    private String email;

    /**
     * строка с паролем
     */
    private String password;

    /**
     * конструктор класса
     *
     * @param email    адрес почты
     * @param password строка с паролем
     */
    public AuthorizationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * конструктор класса
     *
     * @param email адрес почты
     */
    public AuthorizationRequest(String email) {
        this.email = email;
    }
}