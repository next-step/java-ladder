package nextstep.ladder.domain;

public class Participant {
    public static final String PARTICIPANT_NAME_LENGTH_EXCEPTION = "참가자의 이름은 1자에서 5자 사이여야 합니다.";
    private final String name;

    public Participant(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (outOfRange(name)) {
            throw new IllegalStateException(PARTICIPANT_NAME_LENGTH_EXCEPTION);
        }
    }

    private boolean outOfRange(String name) {
        return name.isEmpty() || name.isBlank() || name.length() > 5;
    }
}
