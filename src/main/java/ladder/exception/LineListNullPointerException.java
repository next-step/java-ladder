package ladder.exception;

public final class LineListNullPointerException extends RuntimeException {

    private final String message = "List<Line>이 null 입니다.";

    @Override
    public final String getMessage() {
        return message;
    }
}
