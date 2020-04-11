package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final int RULE_PLAYER_MIN_COUNT = 2;
    private List<Player> players;

    public Players(List<String> players) {
        validate(players);
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

    private void validate(List<String> players) {
        if (players.size() < RULE_PLAYER_MIN_COUNT) {
            throw new IllegalArgumentException(String.format("플레이어는 %d명 이상이어야 합니다.", RULE_PLAYER_MIN_COUNT));
        }
    }
}
