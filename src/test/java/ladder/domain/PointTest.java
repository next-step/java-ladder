package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class PointTest {

    @Test
    @DisplayName("생성 테스트")
    void of() {
        assertThatCode(() -> Point.first(true)).doesNotThrowAnyException();
    }


    @Test
    public void first() {
        assertThat(Point.first(true).move()).isEqualTo(1);
        assertThat(Point.first(false).move()).isEqualTo(0);
    }

    @Test
    public void next_stay() {
        Point second = Point.first(false).next(false);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        Point second = Point.first(true).next(false);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        Point second = Point.first(false).next(true);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    public void next() {
        Point second = Point.first(true).next();
        assertThat(second.move()).isEqualTo(0);
    }

}
