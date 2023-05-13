package com.usman.hostelmanagementsystem.exception;

import com.usman.hostelmanagementsystem.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@ControllerAdvice
public class MainException {
    @ExceptionHandler(value = {BusinessException.class})
    public final ResponseEntity<ResponseDto> handleException(BusinessException e) {
        return createResponse(e.getHttpStatus(), e.getMessage(), e);
    }

    @ExceptionHandler(value = {Exception.class})
    public final ResponseEntity<ResponseDto> handleException(Exception e) {
        return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL ERROR", e);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> GeneralExeption(MethodArgumentNotValidException ex){
        Map<String ,String> map= new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(fieldError -> map.put(fieldError.getField(),fieldError.getDefaultMessage()));

        return map;

    }

    private final ResponseEntity<ResponseDto> createResponse(HttpStatus httpStatus, String message, Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(httpStatus).body(ResponseDto.builder().
                statusCode(httpStatus.value()).status(httpStatus.name()).message(message).success(false).build());
    }
}
