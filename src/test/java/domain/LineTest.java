package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;

public class LineTest {
    @Test(expected = RuntimeException.class)
    public void manualLine_wrong() {
        new Line(Arrays.asList(false, false, false));
    }

    @Test
    public void paint() {
        final Line line = new Line(Arrays.asList(true, false, true));
        final int spacingLetterLength = 5;

        String lineLooks = line.paint(spacingLetterLength);
        String expected = Line.BAR
                + StringUtils.repeat(Line.LINE_LOOKS, spacingLetterLength) + Line.BAR
                + StringUtils.repeat(Line.LINE_LOOKS_NONE, spacingLetterLength) + Line.BAR
                + StringUtils.repeat(Line.LINE_LOOKS, spacingLetterLength) + Line.BAR;

        assertThat(lineLooks).isEqualTo(expected);
    }
}