package nextstep.ladder;

import nextstep.ladder.point.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {


    @ParameterizedTest
    @CsvSource(value = {"true,false,true", "false,false,false"})
    void first(boolean firstMovableRight, boolean expectedFirstMovableLeft, boolean expectedFirstMovableRight) {
        Point first = Point.first(firstMovableRight);

        assertEquals(expectedFirstMovableLeft, first.isMovableLeft());
        assertEquals(expectedFirstMovableRight, first.isMovableRight());
    }

    @ParameterizedTest
    @CsvSource(value = {"false,false,false", "true,true,false"})
    void last(boolean firstMovableRight, boolean expectedLastMovableLeft, boolean expectedLastMovableRight) {
        Point first = Point.first(firstMovableRight);
        Point last = first.last();

        assertEquals(expectedLastMovableLeft, last.isMovableLeft());
        assertEquals(expectedLastMovableRight, last.isMovableRight());
    }

    @ParameterizedTest
    @CsvSource(value = {"false,false,false", "true,false,false"})
    void next(boolean firstMovableRight, boolean secondMovableRight, boolean expectedSecondMovableRight) {
        Point first = Point.first(firstMovableRight);
        Point second = first.next(secondMovableRight);

        assertEquals(firstMovableRight, second.isMovableLeft());
        assertEquals(expectedSecondMovableRight, second.isMovableRight());
    }

    @ParameterizedTest
    @CsvSource(value = {"true,1", "false,0"})
    void first_move(boolean movableRight, int expectedMove) {
        Point first = Point.first(movableRight);
        assertThat(expectedMove).isEqualTo(first.move());
    }

    @ParameterizedTest
    @CsvSource(value = {"true,false,0", "false,false,1", "false,true,2"})
    void second_move(boolean firstMovableRight, boolean secondMovableRight, int expectedMove) {
        Point first = Point.first(firstMovableRight);
        Point second = first.next(secondMovableRight);

        assertThat(expectedMove).isEqualTo(second.move());
    }

    @ParameterizedTest
    @CsvSource(value = {"true,0", "false,1"})
    void last_move(boolean movableRight, int expectedMove) {
        Point first = Point.first(movableRight);
        Point last = first.last();
        assertThat(expectedMove).isEqualTo(last.move());
    }
}
