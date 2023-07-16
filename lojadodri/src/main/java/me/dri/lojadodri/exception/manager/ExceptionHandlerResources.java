package me.dri.lojadodri.exception.manager;


import com.sun.net.httpserver.HttpsServer;
import me.dri.lojadodri.exception.ex.ResourceNotFoundEx;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class ExceptionHandlerResources {


    @ExceptionHandler(ResourceNotFoundEx.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundEx e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Resource not found";
        ExceptionResponse err = new ExceptionResponse(new Date(), error, e.getMessage(), status.value());
        return ResponseEntity.status(status).body(err);
    }

}
