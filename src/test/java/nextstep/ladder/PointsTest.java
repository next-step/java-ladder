package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {
    private Points points;

    @Test
    @DisplayName("생성된 Points 사이즈 확인")
    void size() {
        points = new Points(5);
        assertThat(points.getSize()).isEqualTo(5);
    }

    @Test
    void 결과_인덱스_목록_조회() {
        points = new Points(List.of(new Point(false, false), new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false)));
        assertThat(points.getResultIndexs()).isEqualTo(Arrays.asList(0, 2, 1, 4, 3));

        points = new Points(List.of(new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false), new Point(false, false)));
        assertThat(points.getResultIndexs()).isEqualTo(Arrays.asList(1, 0, 3, 2, 4));
    }
}
