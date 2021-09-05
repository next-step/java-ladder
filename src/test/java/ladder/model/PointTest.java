package ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class PointTest {

    @Test
    void 첫번째는_오른쪽의_연결_여부에_따라_이동() {
        assertThat(Point.first(true).move()).isEqualTo(1);
        assertThat(Point.first(false).move()).isEqualTo(0);
    }

    @Test
    void 제자리_움직이기() {
        Point next = Point.first(false).next(false);
        assertThat(next.move()).isEqualTo(1);
    }

    @Test
    void 오른쪽으로_움직이기() {
        Point next = Point.first(false).next(true);
        assertThat(next.move()).isEqualTo(2);
    }

    @Test
    void 왼쪽으로_움직이기() {
        Point next = Point.first(true).next(false);
        assertThat(next.move()).isEqualTo(0);
    }

}
