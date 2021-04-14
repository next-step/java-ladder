package ladder.exception;

public final class PointListNullPointerException extends RuntimeException {

    private final String message = "List<Point>가 null 입니다.";

    @Override
    public final String getMessage() {
        return message;
    }
}
