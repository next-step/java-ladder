package nextstep.refactoring.ladder.engine.dto;

import nextstep.refactoring.view.interfaces.Dto;

import java.util.List;

public interface LadderDto extends Dto {

    List<LineDto> lineDtoList();

}
