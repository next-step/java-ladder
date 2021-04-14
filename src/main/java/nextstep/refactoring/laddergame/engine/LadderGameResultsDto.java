package nextstep.refactoring.laddergame.engine;

import nextstep.refactoring.view.interfaces.Dto;

import java.util.List;

public interface LadderGameResultsDto extends Dto {

    List<LadderGameResultDto> ladderGameResults();

}
