package nextstep.ladder.domain.line;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    private DirectionSelector directionSelectorForTrue;
    private DirectionSelector directionSelectorForFalse;

    @BeforeEach
    public void setUp() {
        directionSelectorForTrue = () -> true;
        directionSelectorForFalse = () -> false;
    }
    @Test
    public void first() {
        assertThat(Point.first(directionSelectorForTrue).move()).isEqualTo(1);
        assertThat(Point.first(directionSelectorForFalse).move()).isEqualTo(0);
    }

    @Test
    public void next_stay() {
        Point second = Point.first(directionSelectorForFalse).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        Point second = Point.first(directionSelectorForTrue).next(FALSE);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        Point second = Point.first(directionSelectorForFalse).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    public void next() {
        Point second = Point.first(directionSelectorForTrue).next();
        assertThat(second.move()).isEqualTo(0);
    }
}
