package ladder.ladder;

import ladder.line.Line;
import ladder.line.move.LadderPosition;
import ladder.line.move.Direction;
import ladder.line.move.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("참가자가 4명일 때 높이가 3인 사다리를 만들 수 있다.")
    @Test
    void create() {
        Ladder ladder = new Ladder(4, 3, () -> true);

        List<Direction> expectedDirections = List.of(
                Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT,
                Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT,
                Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT
        );

        assertThat(ladder.getLines())
                .hasSize(3)
                .flatExtracting(Line::getLadderPositions)
                .extracting(LadderPosition::getDirection)
                .isEqualTo(expectedDirections);
    }

    @DisplayName("사다리를 이동시켜 마지막 위치를 반환 받을 수 있다.")
    @Test
    void movePoints() {
        Ladder ladder = new Ladder(4, 3, () -> true);

        List<Position> positions = ladder.movePoints();

        assertThat(positions)
                .extracting("value")
                .containsExactly(1, 0, 3, 2);
    }
}
