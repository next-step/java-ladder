package ladder.domain.ladder;

import ladder.exception.InvalidLadderHeightException;
import ladder.exception.InvalidParticipantsCountException;

import java.util.Objects;

public class LadderSize {
    private static final int MIN_PARTICIPANT_COUNT = 1;
    private static final int MIN_LADDER_HEIGHT = 1;

    private final int countOfParticipants;
    private final int ladderHeight;

    public LadderSize(int countOfParticipants, int ladderHeight) {
        validate(countOfParticipants, ladderHeight);
        this.countOfParticipants = countOfParticipants;
        this.ladderHeight = ladderHeight;
    }

    public LadderSize(int countOfParticipants) {
        this(countOfParticipants, MIN_LADDER_HEIGHT);
    }

    private void validate(final int countOfParticipants, final int ladderHeight) {
        if (countOfParticipants < MIN_PARTICIPANT_COUNT) {
            throw new InvalidParticipantsCountException(countOfParticipants, MIN_PARTICIPANT_COUNT);
        }

        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new InvalidLadderHeightException(ladderHeight, MIN_LADDER_HEIGHT);
        }
    }

    public int getCountOfParticipants() {
        return countOfParticipants;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public int getMaxWidthPosition() {
        return countOfParticipants - 1;
    }

    public int getMaxHeightPosition() {
        return ladderHeight - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderSize that = (LadderSize) o;
        return countOfParticipants == that.countOfParticipants && ladderHeight == that.ladderHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfParticipants, ladderHeight);
    }
}