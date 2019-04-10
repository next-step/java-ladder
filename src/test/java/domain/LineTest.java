package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class LineTest {
    @Test
    public void 전달한_길이의_라인을_생성한다() {
        Line line = Line.newLine(5, () -> Boolean.TRUE);
        assertThat(line.getPoints()).hasSize(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 길이_2_미만의_라인은_생성할수_없다() {
        Line.newLine(1, () -> Boolean.TRUE);
    }

    @Test
    public void 이동가능한_포인트가_연속될수_없다() {
        Line line = Line.newLine(3, () -> Boolean.TRUE);
        assertThat(line.getPoints().get(0).rightMovable()).isTrue();
        assertThat(line.getPoints().get(1).rightMovable()).isFalse();
    }

    @Test
    public void 마지막_포인트는_오른쪽으로_이동불가능하다() {
        Line line = Line.newLine(5, () -> Boolean.TRUE);
        assertThat(line.getPoints().get(4).rightMovable()).isFalse();
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
