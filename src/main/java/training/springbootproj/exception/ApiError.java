package training.springbootproj.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class ApiError{

    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public String toString() {
        return "ApiError{" +
                "httpStatus=" + httpStatus +
                ", message='" + message + '\'' +
                '}';
    }
}
