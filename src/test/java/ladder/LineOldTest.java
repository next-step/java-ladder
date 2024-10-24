package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LineOldTest {

    @Test
    void 생성() {
        LineOld lineOld = new LineOld(2, new FixedLineGenerator());
        assertThat(lineOld).isEqualTo(new LineOld(false, false));
    }

    @Test
    void 가로선을_확인해서_이동된_위치를_반환한다() {
        LineOld lineOld = new LineOld(true, false);
        int nextPoint = lineOld.findNextPoint(0);

        assertThat(nextPoint).isEqualTo(1);
    }
}
