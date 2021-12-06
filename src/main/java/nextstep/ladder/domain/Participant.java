package nextstep.ladder.domain;

public class Participant {
    public static final int SIZE = 5;

    private String participant;

    private Participant(String participant) {
        checkParticipantLength(participant);
        this.participant = participant;
    }

    public static Participant of(String participant){
        return new Participant(participant);
    }

    private void checkParticipantLength(String participant) {
        if (participant.length() > SIZE) {
            throw new IllegalArgumentException("이름의 길이가 "+SIZE+"를 초과합니다.");
        }
        if (participant.length() == 0) {
            throw new IllegalArgumentException("이름의 길이가 0보다 커야합니다.");
        }
    }

    public String getParticipant() {
        return participant;
    }

    public int getParticipantLength() {
        return participant.length();
    }
}
