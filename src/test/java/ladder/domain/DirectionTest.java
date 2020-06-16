package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("Direction 클래스 테스트")
public class DirectionTest {

    @Test
    void create() {
        assertThatCode(() -> new Direction(true, false))
                .doesNotThrowAnyException();
    }

    @Test
    void first() {
        Direction first = Direction.first(true);
        assertThat(first.isLeft()).isFalse();
    }

    @Test
    void last() {
        Direction last = Direction.first(true).last();
        assertThat(last.isRight()).isFalse();
    }

    @Test
    void next_true() {
        Direction next = Direction.first(false).next(true);
        assertThat(next.isRight()).isTrue();
    }

    @Test
    public void next_strategy_true() {
        Direction next = Direction.first(false).next(new alwaysTruePointGenerationStrategy());
        assertThat(next.isRight()).isTrue();
    }

    private static class alwaysTruePointGenerationStrategy implements PointGenerationStrategy {
        @Override
        public boolean generate() {
            return true;
        }
    }
}
