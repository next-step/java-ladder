package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Player> players;

    public Players(List<String> players) {
        this.players = new ArrayList<>();
        int playersCount = players.size();
        for (int i = 0; i < playersCount; i++) {
            this.players.add(Player.of(players.get(i), i + 1));
        }
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(this.players);
    }

    public String getPlayerName(int order) {
        return this.players.stream()
                .filter(p -> p.isOrder(order))
                .findFirst()
                .map(p -> p.getName())
                .orElseThrow(() -> new IllegalArgumentException("해당 순서의 플레이어가 없습니다."));
    }

    public int getCount() {
        return this.players.size();
    }
}
