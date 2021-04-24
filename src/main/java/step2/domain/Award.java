package step2.domain;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class Award {
    private final List<Player> players;
    private final List<String> prizes;

    public Award(List<Player> players, List<String> prizes) {
        this.players = players;
        this.prizes = prizes;
    }

    public Map<Player, String> getAward() {
        return players.stream()
                .collect(toMap(
                        identity(),
                        player -> prizes.get(player.getPosition().getValue())));
    }

}
