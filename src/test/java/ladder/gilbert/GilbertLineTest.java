package ladder.gilbert;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GilbertLineTest {

    @Test
    void 사다리_계산() {
        GilbertLine line1 = new GilbertLine("|-| |");
        assertThat(line1.run(0)).isEqualTo(1);
        assertThat(line1.run(1)).isEqualTo(0);
        assertThat(line1.run(2)).isEqualTo(2);

        GilbertLine line2 = new GilbertLine("| |-|");
        assertThat(line2.run(0)).isEqualTo(0);
        assertThat(line2.run(1)).isEqualTo(2);
        assertThat(line2.run(2)).isEqualTo(1);

        GilbertLine line3 = new GilbertLine("| | |");
        assertThat(line3.run(0)).isEqualTo(0);
        assertThat(line3.run(1)).isEqualTo(1);
        assertThat(line3.run(2)).isEqualTo(2);
    }
}
