package nextstep.step2.dto;

import java.util.List;

public class PlayersDTO {
    private final List<String> names;

    public PlayersDTO(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }
}
