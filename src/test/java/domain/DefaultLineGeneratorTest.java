package domain;

import static domain.Line.BAR;
import static domain.Line.LINE_LOOKS_NONE;
import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class DefaultLineGeneratorTest {

    @Test
    public void generatedLine_always_can_paint() {
        final int lineSize = 3;
        final int spacingLetterLength = 2;

        final String oneEmptyLine = StringUtils.repeat(LINE_LOOKS_NONE, spacingLetterLength) + BAR;
        final String wrongLine = BAR + StringUtils.repeat(oneEmptyLine, lineSize); // "| | | |"

        final Line line = new DefaultLineGenerator().generate(lineSize);

        System.out.println("WRONG   -->  " + wrongLine);
        System.out.println("ACTUAL  -->  " + line.paint(spacingLetterLength));

        assertThat(line.paint(spacingLetterLength))
            .isNotEqualTo(wrongLine);
    }
}