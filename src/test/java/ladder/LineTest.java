package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 생성() {
        Line line = new Line(2, new FixedLineGenerator());
        assertThat(line).isEqualTo(new Line(false, false));
    }

    @Test
    void 가로선을_확인해서_이동된_위치를_반환한다() {
        Line line = new Line(true, false);
        int nextPoint = line.findNextPoint(0);

        assertThat(nextPoint).isEqualTo(1);
    }
}
