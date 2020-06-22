package nextstep.ladder.domain;

import nextstep.ladder.constant.LadderConstants;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Players {

    private List<Player> players;

    private Players() {
        this.players = new ArrayList<>();
    }

    public static Players of(List<String> playerNames) {
        validatePlayerNames(playerNames);

        Players players = new Players();

        IntStream.range(0, playerNames.size()).forEach(i -> {
            PlayerName playerName = PlayerName.of(playerNames.get(i));
            PlayerIndex playerIndex = PlayerIndex.of(i + 1);

            players.addToPlayers(Player.of(playerName, playerIndex));
        });

        return players;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Player getPlayer(PlayerName name) {
        return this.players.stream()
                .filter(player -> player.isEqualWithPlayerName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(LadderConstants.INVALID_USER_NAME_IN_EXECUTION_RESULTS));
    }

    private void addToPlayers(Player player) {
        this.players.add(player);
    }

    private static void validatePlayerNames(List<String> playerNames) {
        if (CollectionUtils.isEmpty(playerNames)) {
            throw new IllegalArgumentException(LadderConstants.PLAYER_NAME_ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }
}
