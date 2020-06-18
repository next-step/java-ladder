package ladder.domain.ladder;

import ladder.domain.strategy.FalseLineStrategy;
import ladder.domain.strategy.LineStrategy;
import ladder.domain.strategy.TrueLineStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PointTest {

    @Test
    void createPointWithLine() {
        LineStrategy lineStrategy = new TrueLineStrategy();

        Point pointWithLine = Point.createFirstPoint(lineStrategy);

        assertThat(pointWithLine.hasLine()).isTrue();
    }

    @Test
    void createPointWithoutLine() {
        LineStrategy lineStrategy = new FalseLineStrategy();

        Point pointWithoutLine = Point.createFirstPoint(lineStrategy);

        assertThat(pointWithoutLine.hasLine()).isFalse();
    }
}
