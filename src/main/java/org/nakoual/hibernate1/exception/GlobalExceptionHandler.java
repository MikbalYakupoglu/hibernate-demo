package org.nakoual.hibernate1.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.nakoual.hibernate1.dto.result.Cause;
import org.nakoual.hibernate1.dto.result.ExceptionResult;
import org.nakoual.hibernate1.dto.result.FailureResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<FailureResult> handleNotFoundException(HttpServletRequest request, NotFoundException ex) {
        FailureResult failureResult = getFailureResult(ex);
        logger.info("returns body: {}", failureResult);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(failureResult);
    }


    @ExceptionHandler(InvalidDatabaseDataException.class)
    public ResponseEntity<ExceptionResult> handleInvalidDatabaseDataException(HttpServletRequest request, InvalidDatabaseDataException ex) {
        logger.error("InvalidDatabaseDataException occurred: ", ex);

        ExceptionResult exceptionResult = getErrorResult(request, ex, new ExceptionResult());
        exceptionResult.setMessage("Database data is invalid. Contact with administrator.");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResult);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ExceptionResult> handleSQLException(HttpServletRequest request, SQLException ex) {
        logger.error("SQLException occurred: ", ex);

        ExceptionResult exceptionResult = getErrorResult(request, ex, new ExceptionResult());
        exceptionResult.setMessage("Unexpected SQL error occurred. Contact with administrator.");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResult);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResult> handleException(HttpServletRequest request, Exception ex) {
        logger.error("Exception occurred: ", ex);

        ExceptionResult exceptionResult = getErrorResult(request, ex, new ExceptionResult());
        exceptionResult.setMessage("Unhandled exception occurred. Contact with administrator.");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResult);
    }

    private FailureResult getFailureResult(RuntimeException ex) {
        List<Cause> causes = new ArrayList<>();
        causes.add(new Cause(ex.getClass().getSimpleName(), ex.getLocalizedMessage()));
        return new FailureResult(causes);
    }

    private ExceptionResult getErrorResult(HttpServletRequest request, Exception ex, ExceptionResult exceptionResult) {
        exceptionResult.setEndpoint(request.getRequestURI());
        exceptionResult.setException(ex.getClass().getSimpleName());
        exceptionResult.setMessage(ex.getLocalizedMessage());
        exceptionResult.setTimestamp(Timestamp.from(Instant.now()).toString());
        return exceptionResult;
    }

}
