package ladder.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class LineTest {

    @Test
    public void 라인이_겹칠때() {
        assertTrue(Line.isSameBefore(new Point(true), new Point(true)));
        assertTrue(Line.isSameBefore(new Point(false), new Point(false)));
    }

    @Test
    public void 라인이_안겹칠때() {
        assertFalse(Line.isSameBefore(new Point(true), new Point(false)));
        assertFalse(Line.isSameBefore(new Point(false), new Point(true)));
    }
}
