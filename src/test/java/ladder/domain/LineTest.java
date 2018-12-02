package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import static ladder.domain.LadderLine.from;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private LadderLine line;

    @Before
    public void setUp() throws Exception {
        line = from(3);
    }

    @Test
    public void 라인은_중복으로_발생할_수_없다() {
        assertThat(line.isValidateLine(true, true)).isEqualTo(true);
        assertThat(line.isValidateLine(false, true)).isEqualTo(false);
        assertThat(line.isValidateLine(true, false)).isEqualTo(false);
    }
}
