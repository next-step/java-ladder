package ladder.exception;

public final class LadderHeightNullPointerException extends RuntimeException {

    private final String message = "LadderHeight 인스턴스가 null 입니다.";

    @Override
    public final String getMessage() {
        return message;
    }
}
