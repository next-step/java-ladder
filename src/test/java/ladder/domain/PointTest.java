package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Point 클래스 테스트")
class PointTest {

    @Test
    void first() {
        Point first = Point.first(new AlwaysTruePointGenerationStrategy());
        assertThat(first.move()).isEqualTo(1);
    }

    @Test
    void last() {
        Point last = Point.first(new AlwaysTruePointGenerationStrategy()).last();
        assertThat(last.move()).isEqualTo(0);
    }

    @Test
    void next() {
        PointGenerationStrategy strategy = new AlwaysTruePointGenerationStrategy();
        Point next = Point.first(strategy).next(strategy);

        assertThat(next.move()).isEqualTo(0);
    }
}
