package nextstep.refactoring.ladder.engine;

import nextstep.refactoring.ladder.engine.dto.LineDto;
import nextstep.refactoring.view.interfaces.ViewObject;

public interface Line extends ViewObject<LineDto> {

    Position move(Position position);
    int getWidth();
    boolean isConnectedToRight(Position position);

}
