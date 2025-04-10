package nextstep.ladder.domain;

import java.util.List;

public class Directions {

    private static final List<Direction> DIRECTIONS = List.of(Direction.LEFT, Direction.RIGHT, Direction.DOWN);

    public static boolean canMove(Junction junction, ParticipantName visitor) {
        return DIRECTIONS
                .stream()
                .anyMatch(option -> option.canMove(junction, visitor));
    }

    public static Junction move(Junction junction, ParticipantName visitor) {
        for (Direction direction : DIRECTIONS) {
            if (direction.canMove(junction, visitor)) {
                Junction moved = direction.move(junction);
                moved.visit(visitor);
                return moved;
            }
        }

        throw new IllegalStateException("이동할 수 없습니다.");
    }

}
