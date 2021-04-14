package nextstep.refactoring.laddergame.concrete;

import nextstep.refactoring.laddergame.engine.LadderGameResult;
import nextstep.refactoring.laddergame.engine.LadderGameResultDto;
import nextstep.refactoring.laddergame.engine.LadderGameResultsDto;
import nextstep.refactoring.view.interfaces.ViewObject;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderGameResultsDtoImpl implements LadderGameResultsDto {

    private final List<LadderGameResultDto> ladderGameResultDtoList;

    public LadderGameResultsDtoImpl(List<LadderGameResultDto> ladderGameResultDtoList) {
        this.ladderGameResultDtoList = ladderGameResultDtoList;
    }

    public static LadderGameResultsDto of(List<LadderGameResult> ladderGameResults) {
        return ladderGameResults.stream()
                                .map(ViewObject::export)
                                .collect(collectingAndThen(toList(), LadderGameResultsDtoImpl::new));
    }

    @Override
    public List<LadderGameResultDto> ladderGameResults() {
        return Collections.unmodifiableList(ladderGameResultDtoList);
    }
}
