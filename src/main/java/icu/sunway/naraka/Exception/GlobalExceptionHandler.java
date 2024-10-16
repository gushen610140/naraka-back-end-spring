package icu.sunway.naraka.Exception;

import icu.sunway.naraka.Entity.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler()
    public ResponseEntity<Result<String>> handleAnyException(Exception ex) {
        System.out.println("全局异常捕获: " + ex.getMessage());
        Result<String> res = new Result<>(500, "Global Exception Catch", ex.getMessage());
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
