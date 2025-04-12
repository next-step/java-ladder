package nextstep.ladder.domain;

import java.util.List;

public class JunctionMover {

    private static final List<Direction> NEXT_ORDER = List.of(
        Direction.LEFT,
        Direction.RIGHT,
        Direction.DOWN
    );

    private static Junction getNext(Junction junction, ParticipantName visitor) {
        return NEXT_ORDER.stream()
            .filter(direction -> {
                return junction.hasNeighbor(direction)
                    && !junction.getNeighbor(direction).isVisited(visitor);
            })
            .map(junction::getNeighbor)
            .findFirst()
            .orElse(null);
    }

    public static boolean canMove(Junction junction, ParticipantName visitor) {
        return getNext(junction, visitor) != null;
    }

    public static Junction move(Junction junction, ParticipantName visitor) {
        Junction next = getNext(junction, visitor);

        if (next == null) {
            throw new IllegalStateException("이동할 수 없습니다.");
        }

        next.visit(visitor);
        return next;
    }

}
