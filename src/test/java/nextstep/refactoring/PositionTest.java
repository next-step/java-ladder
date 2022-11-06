package nextstep.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    private Position first;

    @BeforeEach
    void setUp() {
        first = Position.first(true);
    }

    @Test
    public void first() {
        Position result = new Position(0, Spot.first(true));
        assertThat(first).isEqualTo(result);
    }

    @Test
    public void second() {
        Position second = first.next(false);
        Position result = new Position(1, new Spot(true, false));
        assertThat(second).isEqualTo(result);
    }

    @Test
    public void last() {
        Position last = first.last();

        Spot spotFirst = Spot.first(true);
        Spot spotLast = spotFirst.last();

        Position positionLast = new Position(1, spotLast);
        assertThat(last).isEqualTo(positionLast);
    }
}
