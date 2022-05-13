package nextstep.ladder.domain;

public class Participant {

    private static final int BASE_LENGTH_PARTICIPANT_NAME = 5;
    private static final String BASE_LENGTH_OVER_ERROR_MESSAGE = "참가자 이름의 길이가 기준 길이 5를 초과하였습니다.(입력된 참가자명: %s)";

    private final String name;

    public Participant(String name) {
        validateValueLength(name);
        this.name = name;
    }

    private void validateValueLength(String name) {
        if(name.length() > BASE_LENGTH_PARTICIPANT_NAME) {
            throw new IllegalArgumentException(String.format(BASE_LENGTH_OVER_ERROR_MESSAGE, name));
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
