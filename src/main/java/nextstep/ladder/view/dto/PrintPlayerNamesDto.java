package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Players;

public class PrintPlayerNamesDto {

    private final List<String> playerNames;

    public PrintPlayerNamesDto(final Players players) {
        this.playerNames = players.getValues().stream()
            .map(player -> player.getName().getValue())
            .collect(Collectors.toList());
    }

    public List<String> getPlayerNames() {
        return Collections.unmodifiableList(playerNames);
    }
}
