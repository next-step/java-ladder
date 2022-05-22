package ladder.exception;

import ladder.domain.Person;

public class InvalidNameException extends IllegalArgumentException {

    private static String MESSAGE = "이름은 %d 글자를 초과할 수 없습니다.";

    public InvalidNameException() {
        super(String.format(MESSAGE, Person.MAX_LENGTH));
    }

    public InvalidNameException(String message) {
        super(message);
    }
}
