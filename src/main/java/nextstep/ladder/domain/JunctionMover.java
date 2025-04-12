package nextstep.ladder.domain;

import java.util.List;

public class JunctionMover {

    private static final List<Direction> NEXT_ORDER = List.of(
        Direction.LEFT,
        Direction.RIGHT,
        Direction.DOWN
    );

    private final JunctionVisitRegistry visitRegistry = new JunctionVisitRegistry();

    private Junction findNext(Junction junction, ParticipantName participant) {
        return NEXT_ORDER.stream()
            .filter(junction::hasNeighbor)
            .map(junction::getNeighbor)
            .filter(next -> !visitRegistry.isVisited(next, participant))
            .findFirst()
            .orElse(null);
    }

    public boolean canMove(Junction junction, ParticipantName visitor) {
        return findNext(junction, visitor) != null;
    }

    public Junction move(Junction junction, ParticipantName visitor) {
        Junction next = findNext(junction, visitor);

        if (next == null) {
            throw new IllegalStateException("이동할 수 없습니다.");
        }

        visit(next, visitor);
        return next;
    }

    public Junction moveToEnd(Junction start, ParticipantName participant) {
        Junction curr = start;
        visit(curr, participant);

        while (canMove(curr, participant)) {
            curr = move(curr, participant);
        }

        return curr;
    }

    public void visit(Junction junction, ParticipantName participant) {
        visitRegistry.visit(junction, participant);
    }

}
