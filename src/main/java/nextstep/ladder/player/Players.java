package nextstep.ladder.player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    private List<Player> players;

    public Players(String[] names) {
        this(Stream.of(names)
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public Players(List<Player> players) {
        validateEmpty(players);
        this.players = players;
    }

    private void validateEmpty(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("사람 목록은 null 또는 빈 목록일 수 없습니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public String toString() {
        return players.stream()
                .map(Player::toStringWithBlank)
                .collect(Collectors.joining());
    }
}
