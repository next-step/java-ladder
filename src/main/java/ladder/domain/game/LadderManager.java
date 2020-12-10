package ladder.domain.game;

import ladder.strategy.ConnectionStrategy;

import java.util.List;
import java.util.Objects;

/**
 * Created By mand2 on 2020-12-11.
 */
public class LadderManager {

    public static final String MESSAGE_LADDER_NON_NULL = "어떤 사다리를 만들 건지 입력하세요";
    public static final String MESSAGE_SIZE_MISMATCH_IN_PARTICIPANTS_AND_GOALS = "참가자의 수와 실행결과의 수가 일치하지 않습니다.";

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
        private final Names participants;
        private final Names goals;
        private Ladder ladder;
        private LadderResult ladderResult;

        public Builder(Names participants, Names goals) {
            this.participants = participants;
            this.goals = goals;
        }

        public Builder(LadderManager ladderManager) {
            this.participants = ladderManager.participants;
            this.goals = ladderManager.goals;
            this.ladder = ladderManager.ladder;
            this.ladderResult = ladderManager.ladderResult;
        }

        public Builder ladder(Ladder ladder) {
            this.ladder = ladder;
            return this;
        }

        public Builder ladder(ConnectionStrategy connectionStrategy, int height) {
            this.ladder = Ladder.of(this.participants.getSize(), connectionStrategy, height);
            return this;
        }

        public Builder ladderResult() {
            this.ladderResult = LadderResult.of(this.participants, this.ladder.moveAll(this.goals));
            return this;
        }

        public LadderManager build() {
            validate();
            return new LadderManager(this.ladderResult());
        }

        private void validate() {
            if (Objects.isNull(this.ladder)) {
                throw new NullPointerException(MESSAGE_LADDER_NON_NULL);
            }
            if (this.participants.getSize() != this.goals.getSize()) {
                throw new RuntimeException(MESSAGE_SIZE_MISMATCH_IN_PARTICIPANTS_AND_GOALS);
            }
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
