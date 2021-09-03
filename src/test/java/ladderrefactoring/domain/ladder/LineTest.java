package ladderrefactoring.domain.ladder;

import ladderrefactoring.strategy.DirectionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("Line 생성")
    void create() {
        // given
        int widthOfLadder = 5;
        DirectionStrategy directionStrategy = () -> false;

        // when
        Line line = new Line(widthOfLadder, directionStrategy);

        // then
        assertThat(line).isEqualTo(new Line(widthOfLadder, directionStrategy));
    }

    @Test
    @DisplayName("point 이동")
    void move() {
        // given
        int widthOfLadder = 4;
        Line line = new Line(widthOfLadder, () -> true);

        // when
        int movedPosition1 = line.movePosition(1);
        int movedPosition2 = line.movePosition(2);

        // then
        assertThat(movedPosition1).isEqualTo(0);
        assertThat(movedPosition2).isEqualTo(3);
    }
}