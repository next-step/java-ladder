package nextstep.ladder.domain;

public class Participant {
    public static final String PARTICIPANT_NAME_LENGTH_ERROR = "이름은 5자 이하로 입력해주세요.";
    private String name;

    public Participant(String name) {
        assertParticipantName(name);
        this.name = name;
    }

    private void assertParticipantName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException(PARTICIPANT_NAME_LENGTH_ERROR);
        }
    }

    public String getName() {
        return name;
    }
}
