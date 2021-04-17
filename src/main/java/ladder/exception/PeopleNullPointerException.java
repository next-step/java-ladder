package ladder.exception;

public final class PeopleNullPointerException extends RuntimeException {

    private final String message = "People 인스턴스가 null 입니다.";

    @Override
    public final String getMessage() {
        return message;
    }
}
