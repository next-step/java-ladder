package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private final Map<Player, Prize> resultMap;

    private GameResult(Map<Player, Prize> resultMap) {
        this.resultMap = new HashMap<>(resultMap);
    }

    public static GameResult of(Players players, Ladder ladder, Prizes prizes) {
        return new GameResult(playGame(players, ladder, prizes));
    }

    private static Map<Player, Prize> playGame(Players players, Ladder ladder, Prizes prizes) {
        Map<Player, Prize> resultMap = new HashMap<>();
        int numberOfPlayers = players.numberOfPlayers();

        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = players.getPlayers().get(i);
            Position finalPosition = ladder.goThroughLinesFrom(Position.from(i));
            Prize prize = prizes.getPrizes().get(finalPosition.getPosition());

            resultMap.put(player, prize);
        }
        return resultMap;
    }

    public Map<Player, Prize> getResultMap() {
        return Collections.unmodifiableMap(resultMap);
    }
}
