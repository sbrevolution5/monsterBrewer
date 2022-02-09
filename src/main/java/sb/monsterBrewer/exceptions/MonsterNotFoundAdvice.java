package sb.monsterBrewer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class MonsterNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MonsterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String monsterNotFoundHandler(MonsterNotFoundException ex) {
        return ex.getMessage();
    }
}