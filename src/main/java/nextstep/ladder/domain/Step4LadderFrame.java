package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.engine.Height;
import nextstep.ladder.engine.LadderFrame;
import nextstep.ladder.engine.LadderRails;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.Prizes;
import nextstep.ladder.engine.RailCount;

public class Step4LadderFrame implements LadderFrame {
    private final LadderRails ladderRails;
    private final Height height;

    private Step4LadderFrame(LadderRails ladderRails, Height height) {
        this.ladderRails = ladderRails;
        this.height = height;
    }

    public static LadderFrame of(LadderRails rails, int height) {
        if (rails == null) {
            throw new IllegalArgumentException("ladder rails cannot not be null");
        }
        return new Step4LadderFrame(rails, LadderHeight.of(height));
    }

    @Override
    public Height height() {
        return height;
    }

    @Override
    public RailCount railCount() {
        return ladderRails.railCount();
    }

    @Override
    public Players players() {
        return ladderRails.players();
    }

    @Override
    public Prizes prizes() {
        return ladderRails.prizes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step4LadderFrame that = (Step4LadderFrame) o;
        return Objects.equals(ladderRails, that.ladderRails) && Objects.equals(height, that.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderRails, height);
    }

    @Override
    public String toString() {
        return "Step4LadderFrame{" +
                "ladderRails=" + ladderRails +
                ", height=" + height +
                '}';
    }
}
