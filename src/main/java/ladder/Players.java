package ladder;

import java.util.List;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    public void validate(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException("최소 1명 이상의 플레이어가 존재해야 합니다.");
        }
    }

    public int indexOf(Player player) {
        return IntStream.range(0, players.size())
                .filter(i -> players.get(i).toString().equals(player.toString()))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("해당 이름의 참여자가 없습니다."));
    }

    public int size() {
        return players.size();
    }

    public List<Player> players() {
        return List.copyOf(players);
    }

}
