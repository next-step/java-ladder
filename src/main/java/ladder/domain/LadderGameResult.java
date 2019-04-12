package ladder.domain;

import lombok.Getter;

@Getter
public class LadderGameResult {
    private PlayResults playResults;

    public LadderGameResult(PlayResults playResults) {
        this.playResults = playResults;
    }

    public PlayResult findResult(Player player) {
        return playResults.findResultByPlayer(player);
    }
}
