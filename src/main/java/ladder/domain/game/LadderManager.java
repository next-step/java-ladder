package ladder.domain.game;

import ladder.strategy.ConnectionStrategy;

import java.util.List;
import java.util.Objects;

/**
 * Created By mand2 on 2020-12-11.
 */
public class LadderManager {

    private final Names participants;
    private final Names goals;
    private Ladder ladder;
    private LadderResult ladderResult;

    public LadderManager(Builder builder) {
        this.participants = builder.participants;
        this.goals = builder.goals;
        this.ladder = builder.ladder;
        this.ladderResult = builder.ladderResult;
    }

    public List<Name> getParticipants() {
        return participants.getNames();
    }

    public List<Name> getGoals() {
        return goals.getNames();
    }

    public List<Line> getLadder() {
        return ladder.getLadder();
    }

    public LadderResult getLadderResult() {
        return ladderResult;
    }

    public static class Builder {
        private Names participants;
        private Names goals;
        private Ladder ladder;
        private LadderResult ladderResult;

        public Builder() {}

        public Builder(LadderManager ladderManager) {
            this.participants = ladderManager.participants;
            this.goals = ladderManager.goals;
            this.ladder = ladderManager.ladder;
            this.ladderResult = ladderManager.ladderResult;
        }

        public Builder participants(Names participants) {
            this.participants = participants;
            return this;
        }

        public Builder goals(Names goals) {
            this.goals = goals;
            return this;
        }

        public Builder ladder(Ladder ladder) {
            this.ladder = ladder;
            return this;
        }

        public Builder ladder(ConnectionStrategy connectionStrategy, int height) {
            this.ladder = Ladder.of(this.participants.getSize(), connectionStrategy, height);
            return this;
        }

        public Builder ladderResult(LadderResult ladderResult) {
            this.ladderResult = ladderResult;
            return this;
        }

        public Builder ladderResult() {
            this.ladderResult = LadderResult.of(this.participants, this.ladder.moveAll(this.goals));
            return this;
        }

        public LadderManager build() {
            return new LadderManager(this);
        }

        public LadderManager build(ConnectionStrategy connectionStrategy, int height) {
            return new LadderManager(this
                                        .ladder(connectionStrategy, height)
                                        .ladderResult());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderManager that = (LadderManager) o;
        return Objects.equals(getParticipants(), that.getParticipants()) &&
                Objects.equals(getGoals(), that.getGoals()) &&
                Objects.equals(getLadder(), that.getLadder()) &&
                Objects.equals(getLadderResult(), that.getLadderResult());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParticipants(), getGoals(), getLadder(), getLadderResult());
    }
}
