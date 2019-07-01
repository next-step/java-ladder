package nextstep.step2.dto;

import java.util.List;

public class GameResultDTO {
    private final List<String> results;

    public GameResultDTO(List<String> results) {
        this.results = results;
    }

    public List<String> getGameResults() {
        return results;
    }
}
