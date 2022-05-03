package nextstep.ladder.domain;

import nextstep.ladder.dto.PlayersDto;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

public class Players {

    private final List<PlayerName> players;

    private Players(List<String> playersNames) {
        this.players = playersNames.stream()
                .map(PlayerName::new)
                .collect(toList());
    }

    public static Players create(List<String> playersNames) {
        return new Players(playersNames);
    }

    public List<PlayerName> getPlayers() {
        return unmodifiableList(players);
    }

    public int findPositionByPlayerName(String playerName) {
        return players.indexOf(new PlayerName(playerName));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    public PlayersDto toPlayersDto() {
        return new PlayersDto(this);
    }
}
