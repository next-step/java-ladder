package ladder.exception;

public class DirectionNullPointerException extends RuntimeException {

    private final String message = "Direction이 null 입니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
