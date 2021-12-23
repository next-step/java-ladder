package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.engine.LadderPointGenerateStrategy;

public class LadderBuilder implements nextstep.ladder.engine.LadderBuilder {
    private final LadderFrame ladderFrame;
    private final Height height;

    private LadderBuilder(final LadderFrame ladderFrame, final Height height) {
        this.ladderFrame = ladderFrame;
        this.height = height;
    }

    public static LadderBuilder of(LadderFrame ladderFrame, int height) {
        if (ladderFrame == null) {
            throw new IllegalArgumentException("invalid frame: cannot be null");
        }
        return new LadderBuilder(ladderFrame, Height.of(height));
    }

    public nextstep.ladder.engine.Ladder build(LadderPointGenerateStrategy strategy) {
        return Ladder.of(ladderFrame, height, strategy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderBuilder that = (LadderBuilder) o;
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
