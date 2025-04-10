package nextstep.domain.player;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MIN_PLAYER_COUNT = 2;

    private final List<Player> players;

    public Players(List<Player> players) {
        checkValidPlayerCounts(players);
        this.players = players;
    }

    public int getPlayersCount() {
        return players.size();
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getPlayerName)
                .collect(Collectors.toList());
    }

    private void checkValidPlayerCounts(List<Player> players) {
        if(players.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("참여자는 2명이상이어야 합니다.");
        }
    }
}
