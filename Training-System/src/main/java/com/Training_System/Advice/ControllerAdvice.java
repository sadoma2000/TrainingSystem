package com.Training_System.Advice;

import com.Training_System.Api.ApiException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLSyntaxErrorException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = SQLSyntaxErrorException.class)
    public ResponseEntity SQLSyntaxErrorException(SQLSyntaxErrorException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //Using any HTTP request on a different one in postman
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //To handle the ApiException used in the services
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //requesting a path that doesn't exist
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException e){
        String message= e.getMessage();
        return ResponseEntity.status(404).body(message);
    }

    //using Strings for a path variable declared as int or other types that don't match
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    //using a space in a path variable or just ignore it
    @ExceptionHandler(value = MissingPathVariableException.class)
    public ResponseEntity MissingPathVariableException(MissingPathVariableException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //Duplicate values with a unique restrain
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //sending an object with null values with a not null constraint
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //using a different data type from the one declared in a Json body
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //when using an object that is null and try to get values from it or use it in code, this is handled by the logic (after occurring multiple times) but just in case.
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity NullPointerException(NullPointerException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    //this is just in case we scale the program and forgot the if(X == null) before deleting from the repository or other similar cases when we call a null object
    @ExceptionHandler(value = InvalidDataAccessApiUsageException.class)
    public ResponseEntity InvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
    @ExceptionHandler(value= ApiException.class)
    public ResponseEntity ApiEception(ApiException e){
        String msg =e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }

    @ExceptionHandler(value= TransactionSystemException.class)
    public ResponseEntity TransactionSystemException (TransactionSystemException e){
        String msg =e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }
    @ExceptionHandler(value = HttpMessageNotWritableException.class)
    public ResponseEntity HttpMessageNotWritableException (HttpMessageNotWritableException e){
        String msg =e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }
    //JpaObjectRetrievalFailureException
    @ExceptionHandler(value = JpaObjectRetrievalFailureException.class)
    public ResponseEntity JpaObjectRetrievalFailureException (JpaObjectRetrievalFailureException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }
    @ExceptionHandler(value = JpaSystemException.class)
    public ResponseEntity JpaSystemException(JpaSystemException e){
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ResponseEntity HttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e){
        String msg =e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }

    @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class)
    public ResponseEntity InvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e){
        String msg =e.getMessage();
        return ResponseEntity.status(400).body(msg);
    }

    @ExceptionHandler(value = ResponseStatusException.class)
    public ResponseEntity ResponseStatusException(ResponseStatusException e){
        String msg =e.getMessage();
        return ResponseEntity.status(e.getStatusCode()).body(msg);
    }

}
