package ladder.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private Line line;

    @Before
    public void setup() {
    }

    @Test
    public void 선_생성() {
        line = Line.of(Arrays.asList(true, false, true));
        assertThat(line.size()).isEqualTo(3);

        Line matchs = Line.of(Arrays.asList(true, false, true));
        assertThat(line).isEqualTo(matchs);
    }

    @Test
    public void 선_5개_생성() {
        line = Line.of(5);
        assertThat(line.size()).isEqualTo(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 동일_선_생성() {
        line = Line.of(Arrays.asList(true, true));
    }
}
