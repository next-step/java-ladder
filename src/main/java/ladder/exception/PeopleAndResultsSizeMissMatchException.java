package ladder.exception;

public final class PeopleAndResultsSizeMissMatchException extends RuntimeException {

    private final String message = "참가자 수와 결과의 수가 다릅니다.";

    @Override
    public final String getMessage() {
        return message;
    }
}
