package step4.domain.ladder.dto;

import step4.domain.ladder.Ladder;
import step4.domain.ladder.LadderPlayers;
import step4.domain.ladder.LadderResults;

public class LadderDrawDTO {
    private final LadderPlayers ladderPlayers;
    private final LadderResults ladderResults;
    private final Ladder ladder;

    public static class Builder {

        private LadderPlayers ladderPlayers = null;
        private LadderResults ladderResults = null;
        private Ladder ladder = null;
        public Builder() { }

        public Builder ladderPlayers(LadderPlayers ladderPlayers) {
            this.ladderPlayers = ladderPlayers;
            return this;
        }

        public Builder ladderResults(LadderResults ladderResults) {
            this.ladderResults = ladderResults;
            return this;
        }

        public Builder ladder(Ladder ladder) {
            this.ladder = ladder;
            return this;
        }

        public LadderDrawDTO build() {
            return new LadderDrawDTO(this);
        }
    }
    private LadderDrawDTO(Builder builder) {
        ladderPlayers = builder.ladderPlayers;
        ladderResults = builder.ladderResults;
        ladder = builder.ladder;
    }

    public LadderPlayers getLadderPlayers() {
        return ladderPlayers;
    }

    public LadderResults getLadderResults() {
        return ladderResults;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
