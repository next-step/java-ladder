package nextstep.ladder.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Report {
    private static final String MESSAGE_PLAYER_NOT_FOUND_FORMAT = "Not found Player. Name=%s";
    private final Map<Player, Result> playerResults = new HashMap<>();

    public Report(Players players, Results results) {
        int size = players.getPlayers().size();

        for (int i = 0; i < size; i++) {
            Index index = new Index(i);
            Player player = players.findPlayerByIndex(index);
            Result result = results.findResultByIndex(index);
            playerResults.put(player, result);
        }
    }

    public Result findResultByPlayerName(String name) {
        return Optional.ofNullable(playerResults.get(new Player(name)))
                .orElseThrow(() -> new IllegalArgumentException(String.format(MESSAGE_PLAYER_NOT_FOUND_FORMAT, name)));
    }

    public Map<Player, Result> getPlayerResults() {
        return Collections.unmodifiableMap(playerResults);
    }
}
