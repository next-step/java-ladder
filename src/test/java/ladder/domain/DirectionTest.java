package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Direction 클래스 테스트")
public class DirectionTest {

    @Test
    void create() {
        assertThatCode(() -> new Direction(true, false))
                .doesNotThrowAnyException();
    }

    @Test()
    public void create_invalid() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new Direction(true, true));
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
        Direction next = Direction.first(false).next(new AlwaysTruePointGenerationStrategy());
        assertThat(next.isRight()).isTrue();
    }
}
