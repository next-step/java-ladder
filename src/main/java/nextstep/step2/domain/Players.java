package nextstep.step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players create(List<String> playersName) {
        final var size = playersName.size();
        return new Players(IntStream.range(0, size)
                                    .mapToObj(i -> new Player(i, playersName.get(i)))
                                    .collect(Collectors.toList()));
    }

    public List<Player> getPlayers() {
        return players.stream()
                      .map(Player::new)
                      .collect(Collectors.toList());
    }

    public Player findByName(final String name) {
        return players.stream()
                      .filter(player -> player.equalsName(name))
                      .findFirst()
                      .orElseThrow(() -> new IllegalArgumentException("등록되지 않은 플레이어입니다."));
    }

    public Map<Player, Result> getPlayerRewards(final GameResults gameResults, final Ladder ladder) {
        Map<Player, Result> playerRewards = new HashMap<>();
        for (Player player : players) {
            playerRewards.put(player, player.getPlayerReward(gameResults, ladder.getLines()));
        }
        return playerRewards;
    }

    public int getPlayerCount() {
        return this.players.size();
    }
}
