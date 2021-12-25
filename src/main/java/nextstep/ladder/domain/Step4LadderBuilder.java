package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.LadderBuilder;
import nextstep.ladder.engine.LadderRails;
import nextstep.ladder.engine.LadderPointGenerateStrategy;

public class Step4LadderBuilder implements LadderBuilder {
    private final LadderRails ladderRails;

    private Step4LadderBuilder(final LadderRails ladderRails) {
        this.ladderRails = ladderRails;
    }

    public static Step4LadderBuilder of(LadderRails ladderRails) {
        if (ladderRails == null) {
            throw new IllegalArgumentException("invalid frame: cannot be null");
        }
        return new Step4LadderBuilder(ladderRails);
    }

    public static LadderBuilder of(List<String> names, List<String> resultList) {
        return new Step4LadderBuilder(Step4LadderRails.of(names, resultList));

    }

    public Ladder build(int height, LadderPointGenerateStrategy strategy) {
        return Step4Ladder.of(ladderRails, LadderHeight.of(height), strategy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step4LadderBuilder that = (Step4LadderBuilder) o;
        return Objects.equals(ladderRails, that.ladderRails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderRails);
    }

    @Override
    public String toString() {
        return "LadderBuilder{" +
                "ladderFrame=" + ladderRails +
                '}';
    }
}
