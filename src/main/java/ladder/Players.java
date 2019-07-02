package ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String NAME_SEPARATOR = ",";
    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;
    private static final String ALERT_SHORTAGE_OF_NUMBER_OF_PLAYERS = "플레이어는 최소 2명이 필요합니다.";

    private final List<Player> players;

    private Players(List<Player> players) {
        if (players.size() < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException(ALERT_SHORTAGE_OF_NUMBER_OF_PLAYERS);
        }
        this.players = players;
    }

    public static Players of(String testPlayers) {
        return new Players(Arrays.stream(testPlayers.trim().split(NAME_SEPARATOR))
                .map(String::trim)
                .map(Player::from)
                .collect(Collectors.toList()));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
