package ladder.domain;

import java.util.Objects;

public class ParticipateNumber {
    private final int participateNumber;

    public ParticipateNumber(int participateNumber) {
        this.participateNumber = participateNumber;
    }

    public static ParticipateNumber of(int participateNumber) {
        return new ParticipateNumber(participateNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipateNumber that = (ParticipateNumber) o;
        return participateNumber == that.participateNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(participateNumber);
    }
}
