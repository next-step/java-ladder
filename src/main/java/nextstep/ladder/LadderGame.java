package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String PLAYER_NAME_SPLIT_DELIMITER = ",";

    private final Players players;
    private final Lines lines;

    private LadderGame(final Players players, final Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public static LadderGame of(String playerNames, int height) {
        Players players = Players.of(splitNames(playerNames));
        Lines lines = Lines.of(players.countOfPerson(), height);

        return new LadderGame(players, lines);
    }

    public Players getPlayers() {
        return players;
    }

    public Lines getLines() {
        return lines;
    }

    private static List<String> splitNames(String playerNames) {
        return Arrays.stream(playerNames.split(PLAYER_NAME_SPLIT_DELIMITER))
                .collect(Collectors.toList());
    }
}
