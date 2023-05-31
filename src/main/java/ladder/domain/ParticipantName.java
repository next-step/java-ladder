package ladder.domain;

import java.util.Objects;

public class ParticipantName {

    private static final String PARTICIPANTS_NAMES_ARE_LIMITED_TO_FIVE_CHARACTERS = "사다리 게임에 참여하는 사람의 이름은 최대 5글자입니다.";
    private final String participantName;

    public ParticipantName(String participantName) {
        validateParticipant(participantName);
        this.participantName = participantName;
    }

    private void validateParticipant(String participantName) {
        if (participantName.length() > 5) {
            throw new IllegalArgumentException(PARTICIPANTS_NAMES_ARE_LIMITED_TO_FIVE_CHARACTERS);
        }
    }

    public String getParticipantNameAsString() {
        return participantName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantName that = (ParticipantName) o;
        return Objects.equals(participantName, that.participantName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantName);
    }
}
