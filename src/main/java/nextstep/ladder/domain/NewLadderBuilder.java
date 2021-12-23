package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.engine.Ladder;
import nextstep.ladder.engine.LadderPointGenerateStrategy;

public class NewLadderBuilder implements nextstep.ladder.engine.LadderBuilder {
    private final LadderFrame ladderFrame;
    private final Height height;

    private NewLadderBuilder(final LadderFrame ladderFrame, final Height height) {
        this.ladderFrame = ladderFrame;
        this.height = height;
    }

    public static NewLadderBuilder of(LadderFrame ladderFrame, int height) {
        if (ladderFrame == null) {
            throw new IllegalArgumentException("invalid frame: cannot be null");
        }
        return new NewLadderBuilder(ladderFrame, Height.of(height));
    }

    public Ladder build(LadderPointGenerateStrategy strategy) {
        return NewLadder.of(RailCount.of(ladderFrame.size()), height, strategy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewLadderBuilder that = (NewLadderBuilder) o;
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
