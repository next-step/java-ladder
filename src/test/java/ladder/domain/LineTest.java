package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    public static final Line line1 = new Line(List.of(PointTest.point1, PointTest.point2, PointTest.point3));
    public static final Line line2 = new Line(List.of(PointTest.point1, PointTest.point2, PointTest.point3));
    public static final Line line3 = new Line(List.of(PointTest.point1, PointTest.point2, PointTest.point3));

    @DisplayName("생성 된 라인의 포인트 수는 입력한 수와 같다.")
    @Test
    void create_lines() {
        // given
        int count = 5;

        // when
        Line line = new Line(count, () -> true);

        // then
        assertThat(line.currentPoints()).hasSize(count);
    }

}
