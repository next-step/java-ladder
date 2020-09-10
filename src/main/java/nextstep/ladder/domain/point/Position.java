package nextstep.ladder.domain.point;

import java.util.List;

import static nextstep.ladder.utils.CommonConstant.NUMBER_ONE;
import static nextstep.ladder.utils.CommonConstant.NUMBER_ZERO;

public enum Position {
    RIGHT((position) -> position + NUMBER_ONE),
    LEFT((position) -> position - NUMBER_ONE),
    NONE((position) -> position);

    private Movement movement;

    Position(Movement movement) {
        this.movement = movement;
    }

    public static Position valueOf(List<Point> points, int position) {
        if (points.get(position).isRight()) {
            return RIGHT;
        }
        if ((position != NUMBER_ZERO) && (points.get(position - NUMBER_ONE).isRight())) {
            return LEFT;
        }
        return NONE;
    }

    public int move(int position) {
        return movement.move(position);
    }
}
