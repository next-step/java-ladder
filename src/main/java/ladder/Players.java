package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    private final List<Player> players;

    public Players(String input) {
        List<String> playersOfString = Stream.of(input.split(",")).collect(Collectors.toList());
        this.players = playersOfString.stream().map(Player::new).collect(Collectors.toUnmodifiableList());
        if (playersOfString.size() < 2) {
            throw new IllegalArgumentException("2명이상 입력해주세요");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
