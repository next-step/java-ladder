package generator.ladders.impl;

import domain.ladder.Ladders;
import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FixingHeightProbabilityBasedLineGeneratorTest {

    @Test
    public void 높이5_사다리목록_생성() {
        final int height = 5;
        final int lineSize = 5;

        FixingHeightProbabilityBasedLineGenerator fixingHeightProbabilityBasedLineGenerator =
                new FixingHeightProbabilityBasedLineGenerator(height, 100);
        Ladders ladders = fixingHeightProbabilityBasedLineGenerator.generate(lineSize);

        assertThat(ladders.lineSize())
                .isEqualTo(lineSize);

        assertThat(ladders.height())
                .isEqualTo(height);
    }
}