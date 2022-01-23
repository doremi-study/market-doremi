package com.doremi.marketdoremi.common.error;

import com.doremi.marketdoremi.common.error.exceptions.DoremiException;
import com.doremi.marketdoremi.common.error.exceptions.DoremiRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler({DoremiException.class, DoremiRuntimeException.class})
    public ResponseEntity<ErrorResult> handleDoremiException(Exception e) throws Exception {
        log.error(e.getMessage(), e);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;//내부 서버 오류
        return ResponseEntity.status(status).body(ErrorResult.builder().code(-1).message(e.getMessage()).build());
    }
}
