package ladder.exception;

public final class StringListNullPointerException extends RuntimeException {

    private final String message = "List<String>이 null 입니다.";

    @Override
    public final String getMessage() {
        return message;
    }
}
