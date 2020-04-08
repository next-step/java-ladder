package ladder.exception;

import lombok.Getter;

public enum ExceptionType {
    INVALID_NAME_SIZE("Name length limited to 5 characters"),
    INVALID_RESULT_SIZE("The number of users and the number of game results must be the same"),
    INVALID_LINE_SIZE("The number of lines and the number of game results must be the same"),
    NOT_EXIST_USER("User does not exist");

    @Getter
    private String errorMessage;

    ExceptionType(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
