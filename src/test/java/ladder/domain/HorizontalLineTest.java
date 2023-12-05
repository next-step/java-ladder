package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HorizontalLineTest {

    @Test
    void 사다리_오른쪽으로_이동가능_할_경우_이동() {
        HorizontalLine horizontalLine = new HorizontalLine(true, false, true, false);
        int position = 0;
        assertThat(horizontalLine.move(position)).isEqualTo(1);
    }

    @Test
    void 사다리_왼쪽으로_이동가능_할_경우_이동() {
        HorizontalLine horizontalLine = new HorizontalLine(true, false, true, false);
        int position = 3;
        assertThat(horizontalLine.move(position)).isEqualTo(2);
    }
}
