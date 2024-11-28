package nextstep.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PointTest {
    private Point point;

    @BeforeEach
    void setUp() {
        point = new Point(false, true);
    }


    @Test
    void 결과_인덱스_조회() {
        assertThat(point.getResultIndex(0)).isEqualTo(1);
    }

    @Test
    void 움직인_결과_조회__오른쪽() {
        Point point = new Point(false, true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void 움직인_결과_조회__왼쪽() {
        Point point = new Point(true, false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void 움직인_결과_조회__아래() {
        Point point = new Point(false, false);
        assertThat(point.move()).isEqualTo(Direction.DOWN);
    }

    @Test
    void 유효하지_않은_상태값() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Point point = new Point(true, true);
        });
    }

}
