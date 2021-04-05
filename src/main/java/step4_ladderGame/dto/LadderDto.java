package step4_ladderGame.dto;

import java.util.List;

public class LadderDto {

    List<LadderLineDto> lineDto;

    public LadderDto(List<LadderLineDto> linesDto) {
        this.lineDto = linesDto;
    }

    public List<LadderLineDto> getLineDto() {
        return lineDto;
    }
}
