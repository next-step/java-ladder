package ladder.exception;

public final class ParticipantListNullPointerException extends RuntimeException {

    private final String message = "List<Participant>가 null 입니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
