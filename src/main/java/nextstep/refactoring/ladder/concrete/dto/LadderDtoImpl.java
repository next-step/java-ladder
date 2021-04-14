package nextstep.refactoring.ladder.concrete.dto;

import nextstep.refactoring.ladder.engine.dto.LadderDto;
import nextstep.refactoring.ladder.engine.dto.LineDto;

import java.util.Collections;
import java.util.List;

public class LadderDtoImpl implements LadderDto {

    private final List<LineDto> lineDtoList;

    public LadderDtoImpl(List<LineDto> lineDtoList) {
        this.lineDtoList = lineDtoList;
    }

    @Override
    public List<LineDto> lineDtoList() {
        return Collections.unmodifiableList(lineDtoList);
    }
}
