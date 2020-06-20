package ladder.domain.game;

import ladder.domain.ladder.LadderResults;
import ladder.domain.ladder.Lines;
import ladder.domain.player.LadderPlayer;
import ladder.domain.player.LadderPlayers;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGame {

    public static LadderGameResults start(Lines lines, LadderPlayers ladderPlayers, LadderRewards ladderRewards) {
        LadderResults ladderResults = lines.create();
        Map<LadderPlayer, LadderReward> matchResult = Stream.iterate(0, i -> i + 1)
                .limit(ladderPlayers.getPlayerCount())
                .collect(Collectors.toMap(ladderPlayers::getLadderPlayer, i -> getLadderReward(ladderRewards, ladderResults, i)));

        return new LadderGameResults(matchResult);
    }

    private static LadderReward getLadderReward(LadderRewards ladderRewards, LadderResults ladderResults, Integer i) {
        return ladderRewards.getLadderReward(ladderResults.getResultPosition(i));
    }



}
