package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static nextstep.ladder.domain.IndexTest.ix;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @ParameterizedTest(name = "first: {arguments}")
    @ValueSource(booleans = {true, false})
    public void first(boolean right) {
        assertThat(Point.first(right)).isEqualTo(Point.first(right));
    }

    @Test
    public void move() {
        assertThat(Point.first(true).move()).isEqualTo(ix(1));
        assertThat(Point.first(false).move()).isEqualTo(ix(0));
    }

    @Test
    public void next_stay() {
        Point second = Point.first(false).next(false);
        assertThat(second.isRight()).isFalse();
        assertThat(second.move()).isEqualTo(ix(1));
    }

    @Test
    public void next_left() {
        Point second = Point.first(true).next(false);
        assertThat(second.isRight()).isFalse();
        assertThat(second.move()).isEqualTo(ix(0));
    }

    @Test
    public void next_right() {
        Point second = Point.first(false).next(true);
        assertThat(second.isRight()).isTrue();
        assertThat(second.move()).isEqualTo(ix(2));
    }

    @Test
    public void next() {
        Point second = Point.first(true).next(false);
        assertThat(second.move()).isEqualTo(ix(0));
    }
}
