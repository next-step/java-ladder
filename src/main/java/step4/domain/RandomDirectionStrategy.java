package step4.domain;

import static java.lang.Boolean.*;
import static step4.util.LadderPointGenerator.*;

public class RandomDirectionStrategy implements DirectionStrategy{
    @Override
    public Direction next(Direction direction) {
        if (direction.isRight()) {
            return direction.next(FALSE);
        }
        return direction.next(generatePoint());
    }
}
