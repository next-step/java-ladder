package ladder.domain.ladder;

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
        assertTrue(Line.isOverlap(true, true));
    }

    @Test
    public void 라인이_안겹칠때() {
        assertFalse(Line.isOverlap(true, false));
        assertFalse(Line.isOverlap(false, true));
        assertFalse(Line.isOverlap(false, false));
    }

    @Test
    public void 라인을_그리지_않는다() {
        assertThat(Line.beautify(false)).isEqualTo("     ");
    }

    @Test
    public void 라인을_그린다() {
        assertThat(Line.beautify(true)).isEqualTo("-----");
    }
}
