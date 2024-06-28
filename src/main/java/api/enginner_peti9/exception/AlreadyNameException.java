package api.enginner_peti9.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyNameException extends RuntimeException {
    public AlreadyNameException(String nome) {
        super("O nome do Pet já existe => "+nome);
    }
    public AlreadyNameException(String valor, String nome) {
        super(String.format("%s, %s", nome, valor));
    }
}
