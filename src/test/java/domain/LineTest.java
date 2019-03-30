package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test(expected = IllegalArgumentException.class)
    public void 좌우로_인접한_포인트가_아니면_예외가_발생한다() {
        new Line(Point.of(1,1), Point.of(3,1));
    }

    @Test
    public void 똑같은_좌표를_가진_라인은_동일하다() {
        Line line1 = new Line(Point.of(1, 1), Point.of(2, 1));
        Line line2 = new Line(Point.of(1, 1), Point.of(2, 1));

        assertThat(line1).isEqualTo(line2);
    }

    @Test
    public void 포인트가_라인에_있는지_체크한다() {
        Line line = new Line(Point.of(1, 1), Point.of(2, 1));
        assertThat(line.contains(Point.of(1, 1))).isTrue();
    }

    @Test
    public void 반대편_포인트를_반환한다() {
        Line line = new Line(Point.of(1, 1), Point.of(2, 1));
        assertThat(line.appositePoint(Point.of(1, 1))).isEqualTo(Point.of(2, 1));
    }
}
