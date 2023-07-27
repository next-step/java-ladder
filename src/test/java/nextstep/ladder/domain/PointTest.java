package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void 움직임_가능한_Point() {
        Point point = new Point(true);

        String result = point.toString();

        assertThat(result).isEqualTo("------|");
    }

    @Test
    void 움직임_불가능한_Point() {
        Point point = new Point(false);

        String result = point.toString();

        assertThat(result).isEqualTo("      |");
    }
}
