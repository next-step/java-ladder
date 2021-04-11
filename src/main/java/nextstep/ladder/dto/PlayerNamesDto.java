package nextstep.ladder.dto;

import java.util.List;

public class PlayerNamesDto {

    private final List<String> names;

    public PlayerNamesDto(List<String> names) {
        this.names = names;
    }

    public List<String> getPlayerNames() {
        return names;
    }
}
