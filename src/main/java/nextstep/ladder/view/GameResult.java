package nextstep.ladder.view;

import nextstep.ladder.domain.Game;
import nextstep.ladder.domain.player.Player;

import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {
    private static final String ALL_PLAYERS = "all";
    
    private final Map<Player, String> results;

    public GameResult(Game game) {
        results = game.resultTable();
    }

    public String resultOfPlayer(String playerName) {
        if (playerName.equals(ALL_PLAYERS)) {
            return results.entrySet()
                    .stream()
                    .map(e -> String.format("%s : %s\n", e.getKey().name(), e.getValue()))
                    .collect(Collectors.joining());
        }

        return results.get(Player.of(playerName));
    }
}
