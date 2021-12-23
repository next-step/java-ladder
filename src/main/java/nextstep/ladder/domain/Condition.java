package nextstep.ladder.domain;

import nextstep.ladder.domain.participant.Participants;

import java.util.Objects;

public class Condition {
    public static final String LADDER_HEIGHT_LIMIT_MESSAGE = "사다리 높이는 최소 1단이어야 합니다.";
    public static final int MIN = 1;

    private final int numberOfParticipants;
    private final int heightOfLadder;

    private Condition(int numberOfParticipants, int heightOfLadder) {
        this.numberOfParticipants = numberOfParticipants;
        this.heightOfLadder = heightOfLadder;
    }

    public static Condition of(Participants participants, int heightOfLadder) {
        if (heightOfLadder < MIN) {
            throw new IllegalArgumentException(LADDER_HEIGHT_LIMIT_MESSAGE);
        }
        return new Condition(participants.size(), heightOfLadder);
    }

    public static Condition of(int numberOfParticipants, int heightOfLadder) {
        if (heightOfLadder < MIN) {
            throw new IllegalArgumentException(LADDER_HEIGHT_LIMIT_MESSAGE);
        }
        return new Condition(numberOfParticipants, heightOfLadder);
    }

    public int heightOfLadder() {
        return heightOfLadder;
    }

    public int numberOfParticipants() {
        return numberOfParticipants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condition condition = (Condition) o;
        return numberOfParticipants == condition.numberOfParticipants && heightOfLadder == condition.heightOfLadder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfParticipants, heightOfLadder);
    }

    @Override
    public String toString() {
        return "Condition{" +
                "numberOfParticipants=" + numberOfParticipants +
                ", heightOfLadder=" + heightOfLadder +
                '}';
    }
}
