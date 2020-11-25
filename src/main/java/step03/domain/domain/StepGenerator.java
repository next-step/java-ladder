package step03.domain.domain;

import strategy.PointStrategy;

import java.util.Objects;

public class StepGenerator {
    private final Integer countOfParticipants;
    private final PointStrategy pointStrategy;

    private StepGenerator(Integer countOfParticipants, PointStrategy pointStrategy) {
        this.countOfParticipants = countOfParticipants;
        this.pointStrategy = pointStrategy;
    }

    public static StepGenerator of(Participants participants, PointStrategy pointStrategy) {
        return new StepGenerator(participants.size(), pointStrategy);
    }

    public Step generate() {
        return Step.of(countOfParticipants, pointStrategy);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepGenerator that = (StepGenerator) o;
        return Objects.equals(countOfParticipants, that.countOfParticipants) &&
                Objects.equals(pointStrategy, that.pointStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfParticipants, pointStrategy);
    }
}
