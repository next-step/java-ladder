package ladder.domain.result;

import ladder.domain.line.Ladder;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderResults {
    private List<LadderResult> ladderResults;

    public LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public static LadderResults of(Players players, Rewards rewards, Ladder ladder) {
        return new LadderResults(init(players, rewards, ladder));
    }

    private static List<LadderResult> init(Players players, Rewards rewards, Ladder ladder) {
        List<LadderResult> ladderResults = new ArrayList<>();

        for (int i = 0; i < players.getPlayers().size(); i++) {
            ladderResults.add(LadderResult.of(players.findPlayerName(i), rewards.findPrize(ladder.move(i))));
        }

        return ladderResults;
    }

    public List<LadderResult> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }
}
