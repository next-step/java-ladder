package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<String> names) {
        this.players = createPlayers(names);
    }

    private List<Player> createPlayers(List<String> names) {
        validateNames(names);

        return names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private void validateNames(List<String> names) {
        if (Objects.isNull(names) || names.isEmpty()) {
            throw new PlayersNamesException();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayersCount() {
        return players.size();
    }
}
