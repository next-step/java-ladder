package nextstep.ladder.domain;

public class Participant {

    private static final int BASE_LENGTH_PARTICIPANT_NAME = 5;
    private static final String BASE_LENGTH_OVER_ERROR_MESSAGE = "참가자 이름의 길이가 기준 길이 5를 초과하였습니다.(입력된 참가자명: %s)";
    private static final String PARTICIPANT_NULL_OR_EMPTY_ERROR_MESSAGE = "참가자 이름이 null 또는 empty입니다.";

    private final String name;

    public Participant(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNullAndEmpty(name);
        validateValueLength(name);
    }

    private void validateNullAndEmpty(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException(String.format(BASE_LENGTH_OVER_ERROR_MESSAGE, name));
        }
    }

    private void validateValueLength(String name) {
        if(name.length() > BASE_LENGTH_PARTICIPANT_NAME) {
            throw new IllegalArgumentException(PARTICIPANT_NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
