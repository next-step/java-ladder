package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class PlayersGroup {
    public static final int MINIMUM_PLAYER_COUNTS = 2;

    private final List<Player> players;

    private PlayersGroup(List<Player> players) {
        this.players = players;
    }

    public static PlayersGroup of(List<String> playerNames) {
        validatePlayerCounts(playerNames);
        List<Player> players = playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        return new PlayersGroup(players);
    }

    private static void validatePlayerCounts(List<String> playerNames) {
        int playerCounts = playerNames.size();
        int distinctPlayerCounts = (int) playerNames.stream()
                .distinct()
                .count();
        if (playerCounts < MINIMUM_PLAYER_COUNTS) {
            throw new LadderBuildingException(LadderBuildingException.INVALID_PLAYER_COUNTS);
        }
        if (playerCounts != distinctPlayerCounts) {
            throw new LadderBuildingException(LadderBuildingException.DUPLICATE_PLAYER_NAMES);
        }
    }

    public String getPlayerNameByIndex(int index) {
        return players.get(index).getName();
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int getPlayerCounts() {
        return players.size();
    }
}
