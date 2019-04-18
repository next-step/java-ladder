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
    public void 전달한_위치에서_이동한_위치를_반환한다() {
        Line line1 = Line.newLine(5, () -> Boolean.TRUE);
        assertThat(line1.move(1)).isEqualTo(2);
        assertThat(line1.move(3)).isEqualTo(4);

        Line line2 = Line.newLine(5, () -> Boolean.FALSE);
        assertThat(line2.move(1)).isEqualTo(1);
        assertThat(line2.move(2)).isEqualTo(2);
    }

    @Test
    public void 이전_포인트가_이동가능하면_뒤로_이동한다() {
        Line line = Line.newLine(5, () -> Boolean.TRUE);
        assertThat(line.move(2)).isEqualTo(1);
        assertThat(line.move(4)).isEqualTo(3);
    }
}
