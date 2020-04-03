package ladder.Exception;

import lombok.Getter;

public enum ExceptionType {
    INVALID_NAME_SIZE("Name length limited to 5 characters");

    @Getter
    private String errorMessage;

    ExceptionType(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
