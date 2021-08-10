package nextstep.ladder.view.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Names;

public class PrintPlayerNamesDto {

    private final List<String> playerNames;

    public PrintPlayerNamesDto(final Names playerNames) {
        this.playerNames = playerNames.getValues().stream()
            .map(Name::getName)
            .collect(Collectors.toList());
    }

    public List<String> getPlayerNames() {
        return Collections.unmodifiableList(playerNames);
    }
}
