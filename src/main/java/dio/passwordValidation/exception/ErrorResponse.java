package dio.passwordValidation.exception;
import java.time.LocalDateTime;

public record ErrorResponse(LocalDateTime timestamp, Integer status, String message, String path) {
    
}
