package ladder.domain;

public class Participant {

    private final String EMPTY_MSG = "참가자명이 입력되지 않았습니다.";

    private final String TOO_LONG_NAME_MSG = "참가자 이름은 5자를 초과할 수 없습니다.";

    private final int NAME_MAX_LENGTH = 5;

    private final String value;

    public Participant(String participant) {
        if(empty(participant)) {
            throw new IllegalArgumentException(EMPTY_MSG);
        }
        if(longerThanFive(participant)) {
            throw new IllegalArgumentException(TOO_LONG_NAME_MSG);
        }
        this.value = participant;
    }

    private boolean empty(String source) {
        return source == null || source.isEmpty();
    }

    private boolean longerThanFive(String source) {
        return source.length() > NAME_MAX_LENGTH;
    }

    @Override
    public String toString() {
        return value;
    }
}
