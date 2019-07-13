package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {
    @Test
    void createFirst() {
        Point point = Point.first(()->true);
        assertThat(point.getIndex()).isEqualTo(0);
        assertThat(point.getDirection().isRight()).isTrue();
        assertThat(point.getDirection().isLeft()).isFalse();
    }

    @Test
    void lastPoint() {
        Point point = Point.first(()->true).last();
        assertThat(point.getIndex()).isEqualTo(1);
        assertThat(point.getDirection().isRight()).isFalse();
        assertThat(point.getDirection().isLeft()).isTrue();
    }

    @Test
    void nextPointTrueAndTrue() {
        assertThatIllegalArgumentException().isThrownBy(() -> Point.first(()->true).next(true));
    }

    @Test
    void nextPointTrueAndFalse() {
        Point point = Point.first(() -> true).next(()->true);
        assertThat(point.getIndex()).isEqualTo(1);
        assertThat(point.getDirection().isLeft()).isTrue();
        assertThat(point.getDirection().isRight()).isFalse();
    }

    @Test
    void nextPointFalseAndFalse() {
        Point point = Point.first(() -> false).next(()->false);
        assertThat(point.getIndex()).isEqualTo(1);
        assertThat(point.getDirection().isLeft()).isFalse();
        assertThat(point.getDirection().isRight()).isFalse();
    }
}
