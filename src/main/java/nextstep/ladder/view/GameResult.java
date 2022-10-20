package nextstep.ladder.view;

import nextstep.ladder.domain.Game;
import nextstep.ladder.domain.ladder.Result;
import nextstep.ladder.domain.player.Player;

import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {
    public static final String ALL_PLAYERS = "all";

    private final Map<Player, Result> results;

    public GameResult(Game game) {
        results = game.resultTable();
    }

    public String resultOfPlayer(String playerName) {
        if (playerName.equals(ALL_PLAYERS)) {
            return results.entrySet()
                    .stream()
                    .map(e -> String.format("%s : %s\n", e.getKey().name(), e.getValue().value()))
                    .collect(Collectors.joining());
        }

        String result = results.get(Player.of(playerName)).value();
        if (result == null) {
            throw new IllegalArgumentException(playerName + "은(는) 등록되지 않은 플레이어입니다.");
        }

        return result;
    }
}
