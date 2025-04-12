package nextstep.ladder.domain;

import java.util.List;

public class JunctionMover {

    private static final List<Direction> NEXT_ORDER = List.of(
        Direction.LEFT,
        Direction.RIGHT,
        Direction.DOWN
    );

    private static Junction findNext(Junction junction, ParticipantName visitor) {
        return NEXT_ORDER.stream()
            .filter(direction -> {
                return junction.hasNeighbor(direction)
                    && !junction.getNeighbor(direction).isVisited(visitor);
            })
            .map(junction::getNeighbor)
            .findFirst()
            .orElse(null);
    }

    private static boolean canMove(Junction junction, ParticipantName visitor) {
        return findNext(junction, visitor) != null;
    }

    private static Junction move(Junction junction, ParticipantName visitor) {
        Junction next = findNext(junction, visitor);

        if (next == null) {
            throw new IllegalStateException("이동할 수 없습니다.");
        }

        next.visit(visitor);
        return next;
    }

    public static Junction moveToResult(Junction start, ParticipantName participant) {
        Junction curr = start;
        curr.visit(participant);
        while (canMove(curr, participant)) {
            curr = move(curr, participant);
        }
        return curr;
    }

}
