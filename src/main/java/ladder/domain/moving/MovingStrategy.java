package ladder.domain.moving;

import ladder.domain.line.Line;

public interface MovingStrategy {
    Moving nextMoving(Line line, int pos);

}
