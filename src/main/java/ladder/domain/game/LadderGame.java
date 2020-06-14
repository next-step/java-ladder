package ladder.domain.game;

import ladder.domain.ladder.LadderResults;
import ladder.domain.ladder.Lines;
import ladder.domain.ladder.LinesCreator;
import ladder.domain.ladder.ladderInfo.LadderHeight;
import ladder.domain.player.LadderPlayer;
import ladder.domain.player.LadderPlayers;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGame {
    public static Lines createLadder(int playerCount, LadderHeight ladderHeight) {
        return LinesCreator.create(playerCount, ladderHeight);
    }

    public static LadderGameResults start(Lines lines, LadderPlayers ladderPlayers, LadderRewards ladderRewards) {
        LadderResults ladderResults = lines.create();
        Map<LadderPlayer, LadderReward> matchResult = Stream.iterate(0, i -> i < ladderPlayers.getPlayerCount(), i -> i + 1)
                .collect(Collectors.toMap(ladderPlayers::getLadderPlayer,
                        i -> ladderRewards.getLadderReward(ladderResults.getResultPosition(i))));

        return new LadderGameResults(matchResult);
    }
}
