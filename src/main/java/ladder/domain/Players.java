package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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

    public int getPlayerPosition(String playerName) {
        Optional<Player> playerOne = this.players
                .stream()
                .filter(player -> player.getName().equals(playerName))
                .findFirst();

        return this.players.indexOf(playerOne.orElseThrow(PlayerNameMismatchException::new));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayersCount() {
        return players.size();
    }
}
