package step3.domain.ladder.dto;

import step3.domain.ladder.Ladder;
import step3.domain.ladder.LadderResults;
import step3.domain.ladder.Player;

import java.util.Collections;
import java.util.List;

public class LadderGameInformationDTO {
    private final List<Player> players;
    private final Ladder ladder;
    private final LadderResults ladderResults;

    public LadderGameInformationDTO(Builder builder) {
        players = builder.players;
        ladder = builder.ladder;
        ladderResults = builder.ladderResults;
    }


    public static class Builder {
        private List<Player> players;
        private Ladder ladder;
        private LadderResults ladderResults;

        public Builder players(List<Player> players) {
            this.players = Collections.unmodifiableList(players);
            return this;
        }

        public Builder ladder(Ladder ladder) {
            this.ladder = ladder;
            return this;
        }

        public Builder ladderResults(LadderResults ladderResults) {
            this.ladderResults = ladderResults;
            return this;
        }

        public LadderGameInformationDTO build() {
            return new LadderGameInformationDTO(this);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderResults getLadderResults() {
        return ladderResults;
    }
}
