package api.enginner_peti9.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.CONFLICT)
public class VacinaOpcaoException extends RuntimeException{
    public VacinaOpcaoException(String nome){
        super(nome);
    }
}
