package nextstep.ladder;

import nextstep.ladder.dto.PlayersDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.*;

public class Players {

    private final List<Player> players = new ArrayList<>();

    private Players(String[] playersNames) {
        for (int i = 0; i < playersNames.length; i++) {
            players.add(new Player(new PlayerName(playersNames[i]), i));
        }
    }

    public static Players getNewInstanceByStrings(String[] playersNames) {
        return new Players(playersNames);
    }

    public List<Player> getPlayers() {
        return unmodifiableList(players);
    }

    public int findPositionByPlayerName(String playerName) {
        return players.stream()
                .filter(player -> player.findPlayerName(playerName))
                .map(Player::getPosition)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(playerName + "은 존재하지 않는 플레어이업니다."));
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
