package laddarGame.dto;

import java.util.List;

public class LinesDto {

    List<LineDto> lineDto;

    public LinesDto(List<LineDto> linesDto) {
        this.lineDto = linesDto;
    }

    public List<LineDto> getLineDto() {
        return lineDto;
    }
}
