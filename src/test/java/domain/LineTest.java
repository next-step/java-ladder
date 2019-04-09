package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class LineTest {
    @Test
    public void 전달한_길이의_라인을_생성한다() {
        Line line = Line.newLine(5, () -> Boolean.TRUE);
        assertThat(line.getPoints()).hasSize(5);
    }

    @Test
    public void 포인트간_아무런_연결이_없는_선을_생성한다() {
        Line line = Line.newLine(5, () -> Boolean.FALSE);
        assertThat(line.getPoints()).containsExactly(
            Point.valueOf(1, Boolean.FALSE),
            Point.valueOf(2, Boolean.FALSE),
            Point.valueOf(3, Boolean.FALSE),
            Point.valueOf(4, Boolean.FALSE),
            Point.valueOf(5, Boolean.FALSE)
        );
    }

    @Test
    public void 마지막_포인트는_항상_이동불가능하다() {
        Line line = Line.newLine(5, () -> Boolean.TRUE);
        assertThat(line.getPoints().get(4)).isEqualTo(Point.valueOf(5, Boolean.FALSE));
    }

    @Test
    public void 이동가능한_포인트가_연속될수_없다() {
        Line line = Line.newLine(5, () -> Boolean.TRUE);
        assertThat(line.getPoints()).containsExactly(
            Point.valueOf(1, Boolean.TRUE),
            Point.valueOf(2, Boolean.FALSE),
            Point.valueOf(3, Boolean.TRUE),
            Point.valueOf(4, Boolean.FALSE),
            Point.valueOf(5, Boolean.FALSE)
        );
    }

    @Test
    public void 포인트가_라인에_있는지_체크한다() {
        Line line = Line.newLine(1, () -> Boolean.TRUE);
        assertThat(line.contains(Point.valueOf(1, true))).isTrue();
    }

    @Test
    public void 전달한_위치에서_이동한_위치를_반환한다() {
        Line line1 = Line.newLine(2, () -> Boolean.TRUE);
        assertThat(line1.move(1)).isEqualTo(2);

        Line line2 = Line.newLine(2, () -> Boolean.FALSE);
        assertThat(line2.move(1)).isEqualTo(1);
    }

    @Test
    public void 이전_포인트가_이동가능하면_뒤로_이동한다() {
        Line line = Line.newLine(2, () -> Boolean.TRUE);
        assertThat(line.move(2)).isEqualTo(1);
    }
}
