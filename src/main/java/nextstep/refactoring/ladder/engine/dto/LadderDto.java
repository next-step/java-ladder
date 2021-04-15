package nextstep.refactoring.ladder.engine.dto;

import java.util.Collections;
import java.util.List;

public class LadderDto {

    private final List<LineDto> lineDtoList;

    public LadderDto(List<LineDto> lineDtoList) {
        this.lineDtoList = lineDtoList;
    }

    public List<LineDto> lineDtoList() {
        return Collections.unmodifiableList(lineDtoList);

    }

}
