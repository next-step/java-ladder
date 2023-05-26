package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class HorizontalLineTest {

    @Test
    void addTest() {
        assertThat(HorizontalLine.create(3, () -> true))
            .isEqualTo(new HorizontalLine(List.of(
                new Point(0, DirectionTest.rightDirection),
                new Point(1, DirectionTest.leftDirection),
                new Point(2, DirectionTest.nonDirection)
            )));
    }

    @Test
    void nonAddTest() {
        assertThat(HorizontalLine.create(4, () -> false)).isEqualTo(
            new HorizontalLine(List.of(
                new Point(0, DirectionTest.nonDirection),
                new Point(1, DirectionTest.nonDirection),
                new Point(2, DirectionTest.nonDirection),
                new Point(3, DirectionTest.nonDirection)
            )));
    }

}
