package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 전달한_boolean_만큼_라인을_생성한다() {
        Line line = new Line(Arrays.asList(Boolean.TRUE, Boolean.FALSE));
        assertThat(line.getPoints()).hasSize(2);
    }

    @Test
    public void 이동가능한_포인트가_연속될수_없다() {
        Line line = new Line(Arrays.asList(Boolean.TRUE, Boolean.TRUE));
        List<Point> points = line.getPoints();
        assertThat(points.get(0).isMovable()).isTrue();
        assertThat(points.get(1).isMovable()).isFalse();
    }

    @Test
    public void 포인트가_라인에_있는지_체크한다() {
        Line line = new Line(Arrays.asList(Boolean.TRUE));
        assertThat(line.contains(Point.valueOf(1, true))).isTrue();
    }

    @Test
    public void 전달한_위치에서_이동한_위치를_반환한다() {
        Line line1 = new Line(Arrays.asList(Boolean.TRUE, Boolean.FALSE));
        assertThat(line1.move(1)).isEqualTo(2);

        Line line2 = new Line(Arrays.asList(Boolean.FALSE, Boolean.FALSE));
        assertThat(line2.move(1)).isEqualTo(1);
    }

    @Test
    public void 이전_포인트가_이동가능하면_뒤로_이동한다() {
        Line line = new Line(Arrays.asList(Boolean.TRUE, Boolean.FALSE));
        assertThat(line.move(2)).isEqualTo(1);
    }
}
