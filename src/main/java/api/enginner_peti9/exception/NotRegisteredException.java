package api.enginner_peti9.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(Long id, String nome) {
        super(String.format("Registro não encontrado: %s, %s", nome, id));
    }
}
