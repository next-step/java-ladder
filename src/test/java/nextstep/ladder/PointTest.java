package nextstep.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
