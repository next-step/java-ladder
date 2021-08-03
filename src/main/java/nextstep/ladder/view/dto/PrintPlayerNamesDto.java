package nextstep.ladder.view.dto;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.common.Name;

public class PrintPlayerNamesDto {

    private final List<String> playerNames;

    public PrintPlayerNamesDto(List<Name> playerNames) {
        this.playerNames = playerNames.stream()
            .map(Name::getName)
            .collect(Collectors.toList());
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}
