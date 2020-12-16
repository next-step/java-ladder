package nextstep.laddergame.domain.dto;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderDTO {
    private List<LineDTO> lines;

    private LadderDTO(List<LineDTO> lineDTOS) {
        this.lines = lineDTOS;
    }

    public static LadderDTO from(Ladder ladder) {
        List<LineDTO> lineDTOS = new ArrayList<>();
        for (Line line : ladder.getLines()) {
            lineDTOS.add(LineDTO.from(line));
        }

        return new LadderDTO(lineDTOS);
    }

    public List<LineDTO> getLines() {
        return lines;
    }
}
