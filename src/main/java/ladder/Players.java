package ladder;

import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    public void validate(List<Player> players) {
        if (players.size() < 1) {
            throw new IllegalArgumentException("최소 1명 이상의 플레이어가 존재해야 합니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public List<Player> players() {
        return List.copyOf(players);
    }

}
