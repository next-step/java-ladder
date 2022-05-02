package nextstep.ladder.dto;

import nextstep.ladder.Players;

import java.util.List;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

public class PlayersDto {

    private final List<PlayerNameDto> players;

    public PlayersDto(Players players) {
        this.players = players.getPlayers()
                .stream()
                .map(PlayerNameDto::new)
                .collect(toList());
    }

    public List<PlayerNameDto> getPlayers() {
        return unmodifiableList(players);
    }
}
