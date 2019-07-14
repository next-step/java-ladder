package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private final GameInfo gameInfo;
    private final Ladder ladder;

    private LadderGame(GameInfo gameInfo, Ladder ladder) {
        this.gameInfo = gameInfo;
        this.ladder = ladder;
    }

    public static LadderGame of(GameInfo gameInfo, Ladder ladder) {
        return new LadderGame(gameInfo, ladder);
    }

    public GameResult playGame() {
        Map<Player, Prize> resultMap = new HashMap<>();
        int numberOfPlayers = gameInfo.numberOfPlayers();

        for (int index = 0; index < numberOfPlayers; index++) {
            Player player = gameInfo.findPlayerByIndex(index);
            Position finalPosition = ladder.goThroughLinesFrom(Position.from(index));
            Prize prize = gameInfo.findPrizeByPosition(finalPosition);

            resultMap.put(player, prize);
        }
        return GameResult.from(resultMap);
    }

    public Players getPlayers() {
        return gameInfo.getPlayers();
    }

    public Prizes getPrizes() {
        return gameInfo.getPrizes();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
