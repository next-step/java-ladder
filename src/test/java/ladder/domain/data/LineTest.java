package ladder.domain.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 사다리_계산() {
        Line line1 = new Line("|-| |");
        assertThat(line1.run(0)).isEqualTo(1);
        assertThat(line1.run(1)).isEqualTo(0);
        assertThat(line1.run(2)).isEqualTo(2);

        Line line2 = new Line("| |-|");
        assertThat(line2.run(0)).isEqualTo(0);
        assertThat(line2.run(1)).isEqualTo(2);
        assertThat(line2.run(2)).isEqualTo(1);

        Line line3 = new Line("| | |");
        assertThat(line3.run(0)).isEqualTo(0);
        assertThat(line3.run(1)).isEqualTo(1);
        assertThat(line3.run(2)).isEqualTo(2);
    }
}
