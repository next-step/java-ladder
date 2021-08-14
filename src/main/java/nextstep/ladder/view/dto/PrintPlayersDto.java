package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Players;

public class PrintPlayersDto {

    private final List<PrintPlayerDto> players;

    public PrintPlayersDto(final Players players) {
        this.players = players.getValues().stream()
            .map(PrintPlayerDto::new)
            .collect(Collectors.toList());
    }

    public List<PrintPlayerDto> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
