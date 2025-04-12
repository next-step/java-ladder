package nextstep.ladder.domain;

import java.util.List;

public class JunctionMover {

    private static final List<Direction> DIRECTIONS = List.of(
        Direction.LEFT,
        Direction.RIGHT,
        Direction.DOWN
    );

    private static Junction getNext(Junction junction, ParticipantName visitor) {
        return DIRECTIONS.stream()
            .filter(direction -> {
                return junction.hasByDirection(direction)
                    && !junction.getByDirection(direction).isVisited(visitor);
            })
            .map(junction::getByDirection)
            .findFirst()
            .orElse(null);
    }

    public static boolean canMove(Junction junction, ParticipantName visitor) {
        return getNext(junction, visitor) != null;
    }

    public static Junction move(Junction junction, ParticipantName visitor) {
        Junction next = getNext(junction, visitor);
        next.visit(visitor);
        return next;
    }

}
