package ladder.domain;

import java.util.ArrayList;
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
        validationPlayers(players);
        this.players = new ArrayList<>(players);
    }

    public static Players of(String inputNames) {
        return new Players(Arrays.stream(inputNames.trim().split(NAME_SEPARATOR))
                .map(String::trim)
                .map(Player::from)
                .collect(Collectors.toList()));
    }

    private void validationPlayers(List<Player> players) {
        if (players.size() < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException(ALERT_SHORTAGE_OF_NUMBER_OF_PLAYERS);
        }
    }

    public int numberOfPlayers() {
        return players.size();
    }

    Player findPlayerByIndex(int index) {
        return players.get(index);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
