package nextstep.ladder;

import nextstep.ladder.dto.PlayersDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.*;

public class Players {

    private final List<PlayerName> players = new ArrayList<>();

    private Players(String[] playersNames) {
        for (String playersName : playersNames) {
            players.add((new PlayerName(playersName)));
        }
    }

    public static Players getNewInstanceByStrings(String[] playersNames) {
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
