package ladder.exception;

public class InvalidNameOfParticipant extends RuntimeException {
    private static final String MESSAGE = "ERROR] 참가자의 이름은 0자 초과 5자 이하입니다(입력된 이름: %s).";

    public InvalidNameOfParticipant(String name) {
        super(String.format(MESSAGE, name));
    }
}
