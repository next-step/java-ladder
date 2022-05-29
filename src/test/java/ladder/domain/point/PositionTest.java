package ladder.domain.point;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ladder.domain.point.Position.INITIAL_POSITION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Test
    void Position은_초기값_미만으로_생성_할_경우_예외를_발생_시킨다() {
        assertThatThrownBy(
                () -> new Position(INITIAL_POSITION - 1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"LEFT|0", "NONE|1", "RIGHT|2"}, delimiter = '|')
    void move는_방향으로_이동된_position을_반환한다(Direction direction, int position) {
        Position previousPosition = new Position(1);

        Position movedPosition = previousPosition.move(direction);

        assertEquals(new Position(position), movedPosition);
    }

    @Test
    void initialize는_초기값으로_position을_생성한다() {
        assertEquals(Position.initialize(), new Position(INITIAL_POSITION));
    }

    @Test
    void next는_다음_position을_반환한다() {
        Position previousPosition = new Position(1);

        Position movedPosition = previousPosition.next();

        assertEquals(new Position(2), movedPosition);
    }
}
