package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.engine.Height;
import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.LadderBuilder;
import nextstep.ladder.engine.LadderFrame;
import nextstep.ladder.engine.LadderPointGenerateStrategy;

public class Step4LadderBuilder implements LadderBuilder {
    private final LadderFrame ladderFrame;
    private final Height height;

    private Step4LadderBuilder(final LadderFrame ladderFrame, final Height height) {
        this.ladderFrame = ladderFrame;
        this.height = height;
    }

    public static Step4LadderBuilder of(LadderFrame ladderFrame, int height) {
        if (ladderFrame == null) {
            throw new IllegalArgumentException("invalid frame: cannot be null");
        }
        return new Step4LadderBuilder(ladderFrame, LadderHeight.of(height));
    }

    public Ladder build(LadderPointGenerateStrategy strategy) {
        return Step4Ladder.of(ladderFrame, height, strategy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step4LadderBuilder that = (Step4LadderBuilder) o;
        return Objects.equals(ladderFrame, that.ladderFrame) && Objects.equals(height, that.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderFrame, height);
    }

    @Override
    public String toString() {
        return "LadderBuilder{" +
                "ladderFrame=" + ladderFrame +
                ", height=" + height +
                '}';
    }
}
