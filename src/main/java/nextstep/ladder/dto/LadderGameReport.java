package nextstep.ladder.dto;

import java.util.List;

public class LadderGameReport {

    private final List<PlayerDto> playerDtoList;

    public LadderGameReport(List<PlayerDto> playerDtoList) {
        this.playerDtoList = playerDtoList;
    }

    public List<PlayerDto> getPlayerDtoList() {
        return playerDtoList;
    }
}
