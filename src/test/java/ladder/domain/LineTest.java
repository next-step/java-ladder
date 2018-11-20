package ladder.domain;

import ladder.domain.ladder.Line;
import ladder.domain.player.People;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private Line line;

    @Before
    public void setUp() throws Exception {
        line = new Line();
    }

    @Test
    public void 겹치는_라인() {
        line.isNotValidateLine(true, true);
        assertThat(line.isNotValidateLine(true, true)).isEqualTo(true);
    }

    @Test
    public void 겹치지_않는_라인() {
        line.isNotValidateLine(true, true);
        assertThat(line.isNotValidateLine(false, true)).isEqualTo(false);
        assertThat(line.isNotValidateLine(true, false)).isEqualTo(false);
    }

    @Test
    public void makeLineTest() {
        line.makeLineLadderPoints(new People("a,b,c"));
    }
}