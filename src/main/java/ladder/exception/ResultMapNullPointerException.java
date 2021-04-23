package ladder.exception;

public final class ResultMapNullPointerException extends RuntimeException {

    private final String message = "Map<Participant, String>가 null 입니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
