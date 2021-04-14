package nextstep.refactoring.ladder.engine;

import nextstep.refactoring.ladder.engine.dto.LadderDto;
import nextstep.refactoring.view.interfaces.ViewObject;

public interface Ladder extends ViewObject<LadderDto> {

    LadderResult run(Position startPosition);
    int numberOfPositions();

}
