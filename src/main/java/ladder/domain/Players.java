package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final int RULE_PLAYER_MIN_COUNT = 2;
    private final List<Player> players;

    public Players(List<String> inputs) {
        int playersCount = inputs.size();
        validate(playersCount);
        this.players = inputsToPlayers(inputs);
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(this.players);
    }

    public String getName(int index) {
        return this.players.get(index).getName();
    }

    public int count() {
        return this.players.size();
    }

    private List<Player> inputsToPlayers(List<String> inputs) {
        List<Player> players = new ArrayList<>();
        for (String input : inputs) {
            players.add(Player.of(input));
        }
        return players;
    }

    private void validate(int playerCount) {
        if (playerCount < RULE_PLAYER_MIN_COUNT) {
            throw new IllegalArgumentException(String.format("플레이어는 %d명 이상이어야 합니다.", RULE_PLAYER_MIN_COUNT));
        }
    }
}
