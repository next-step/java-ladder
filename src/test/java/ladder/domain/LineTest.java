package ladder.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LineTest {

    @Test
    public void 라인_생성() {
        Line line = Line.generate(5);
        assertThat(line.getPoints().size()).isEqualTo(5);
    }

    @Test
    public void 라인이_겹칠때() {
        assertTrue(Line.isOverlap(new Point(true), new Point(true)));
    }

    @Test
    public void 라인이_안겹칠때() {
        assertFalse(Line.isOverlap(new Point(true), new Point(false)));
        assertFalse(Line.isOverlap(new Point(false), new Point(true)));
        assertFalse(Line.isOverlap(new Point(false), new Point(false)));
    }
}
