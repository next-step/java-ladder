package nextstep.ladder.view;

import nextstep.ladder.domain.Game;
import nextstep.ladder.domain.player.Player;

import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {
    public static final String ALL_PLAYERS = "all";

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

        String result = results.get(Player.of(playerName));
        if (result == null) {
            throw new IllegalArgumentException(playerName + "은(는) 등록되지 않은 플레이어입니다.");
        }

        return result;
    }
}
