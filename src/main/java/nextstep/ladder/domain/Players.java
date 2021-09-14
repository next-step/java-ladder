package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MIN_PLAYER_COUNT = 2;
    private List<Player> players;

    public Players(String nameString) {
        this.players = init(nameString);
    }

    private List<Player> init(String nameString) {
        String[] carNameArray = nameString.split(",");

        validPlayerCount(carNameArray.length);

        return Arrays.stream(carNameArray)
                .map(player -> new Player(player))
                .collect(Collectors.toList());
    }

    private void validPlayerCount(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("플레이어는 최소 " +MIN_PLAYER_COUNT + "명 이상 이어야 합니다.");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int numberOfPlayers() {
        return players.size();
    }

}
