package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.ladder.exception.WrongPlayersException;

public class Players {

    private final int MINIMUM_PLAYER_COUNT = 2;

    private final List<Player> players;

    private Players(String[] playerNames) {
        Objects.requireNonNull(playerNames, "플레이어 이름목록은 필수입력입니다.");

        validateMinimumPlayerCount(playerNames.length);

        this.players = Arrays.stream(playerNames)
            .map(Player::new)
            .collect(Collectors.toList());

    }

    private void validateMinimumPlayerCount(int playerCount) {
        if (playerCount < MINIMUM_PLAYER_COUNT) {
            throw new WrongPlayersException(
                String.format("플레이어는 최소 %d명이 필요합니다. [입력된 플레이어 수:%d]", MINIMUM_PLAYER_COUNT, playerCount));
        }
    }

    public void swap(int i, int j) {
        Collections.swap(players, i, j);
    }

    public static Players from(String[] playerNames) {
        return new Players(playerNames);
    }

    public int count() {
        return players.size();
    }

    public String getPlayerNameAt(int index) {
        return value().get(index).getName();
    }

    public List<Player> value() {
        return players;
    }

}
