package step4.dto;

import java.util.Map;

import step4.domain.Player;
import step4.domain.Prize;

public class PlayResultsDto {
    private final Map<Player, Prize> result;

    public PlayResultsDto(Map<Player, Prize> result) {
        this.result = result;
    }

    public Map<Player, Prize> getResult() {
        return this.result;
    }
}
