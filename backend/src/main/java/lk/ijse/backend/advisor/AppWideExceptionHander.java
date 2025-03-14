package lk.ijse.backend.advisor;

import lk.ijse.backend.util.ResponceUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHander {


    @ExceptionHandler(Exception.class)
    public ResponceUtil exceptionHandler(Exception ex){
        return new ResponceUtil(500 ,ex.getMessage() ,null);
    }


}
