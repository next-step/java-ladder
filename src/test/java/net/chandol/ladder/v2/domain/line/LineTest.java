package net.chandol.ladder.v2.domain.line;

import net.chandol.ladder.v2.domain.line.Line;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void hasPoint() {
        Line line = Line.of(true, false);

        assertThat(line.hasPoint(0)).isEqualTo(true);
        assertThat(line.hasPoint(1)).isEqualTo(false);
    }

    @Test
    public void 라인_동등성_테스트() {
        Line first = Line.of(true, false, true);
        Line second = Line.of(true, false, true);

        assertThat(first).isEqualTo(second);
    }
}