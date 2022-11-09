package ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<String> input) {
        this.players = input.stream().map(Player::new).collect(Collectors.toUnmodifiableList());
        if (input.size() < 2) {
            throw new IllegalArgumentException("2명이상 입력해주세요");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
