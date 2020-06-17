package nextstep.ladder.domain;

import nextstep.ladder.constant.LadderConstants;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> players;

    private Players() {
        this.players = new ArrayList<>();
    }

    public static Players of(List<String> playerNames) {
        validatePlayerNames(playerNames);

        Players players = new Players();
        playerNames.forEach(playerName -> players.addToPlayers(Player.of(playerName)));
        return players;
    }

    public List<Player> getPlayers() {
        return this.players;
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
