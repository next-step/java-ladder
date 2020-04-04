package ladder.domain;

import ladder.exception.PlayerException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final String PLAYER_COUNT_ERR_MSG = "2명 이상 참가 가능 합니다.";
    private static final String PLAYER_NOT_FOUND_ERR_MSG = "참가자를 찾을수 없습니다.";
    private static final String DUPLICATE_PLAYER_ERR_MSG = "동일한 이름의 참가자가 있습니다.";
    private static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(final List<Player> players) {
        validatePlayerCount(players);
        validateDuplicatePlayer(players);
        this.players = players;
    }

    public static Players of(final List<String> names) {
        List<Player> collect = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        return new Players(collect);
    }

    private void validateDuplicatePlayer(final List<Player> players) {
        long duplicateCount = players.stream()
                .distinct()
                .count();
        if (players.size() != duplicateCount) {
            throw new PlayerException(DUPLICATE_PLAYER_ERR_MSG);
        }
    }

    private void validatePlayerCount(final List<Player> players) {
        if (players.size() < MIN_PLAYER_COUNT) {
            throw new PlayerException(PLAYER_COUNT_ERR_MSG);
        }
    }

    public int findPlayer(String playerName) {
        playerName = playerName.trim();

        List<String> names = players.stream()
                .map(player -> player.getName())
                .collect(Collectors.toList());

        if (!names.contains(playerName)) {
            throw new PlayerException(PLAYER_NOT_FOUND_ERR_MSG);
        }

        return names.indexOf(playerName);
    }

    public int size() {
        return this.players.size();
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>(this.players);
        return players;
    }
}
