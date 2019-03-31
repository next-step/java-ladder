package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    public void 똑같은_좌표를_가진_라인은_동일하다() {
        Line line1 = Line.valueOf(Point.valueOf(1, 1), Point.valueOf(2, 1));
        Line line2 = Line.valueOf(Point.valueOf(1, 1), Point.valueOf(2, 1));

        assertThat(line1).isEqualTo(line2);
    }

    @Test
    public void 자신의_오른쪽과_연결된_라인을_생성한다() {
        Line line = Line.create(Point.valueOf(1, 1));
        assertThat(line.appositePoint(Point.valueOf(1, 1))).isEqualTo(Point.valueOf(2, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 좌우_인접하지_않으면_예외가_발생한다() {
        Line.valueOf(Point.valueOf(1, 1), Point.valueOf(3, 1));
    }

    @Test
    public void 포인트가_라인에_있는지_체크한다() {
        Line line = Line.create(Point.valueOf(1, 1));
        assertThat(line.contains(Point.valueOf(1, 1))).isTrue();
    }

    @Test
    public void 반대편_포인트를_반환한다() {
        Line line = Line.valueOf(Point.valueOf(1, 1), Point.valueOf(2, 1));
        assertThat(line.appositePoint(Point.valueOf(1, 1))).isEqualTo(Point.valueOf(2, 1));
    }
}
