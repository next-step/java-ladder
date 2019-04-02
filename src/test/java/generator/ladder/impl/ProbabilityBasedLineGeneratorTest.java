package generator.ladder.impl;

import domain.ladder.Ladder;
import generator.ladder.LadderGenerator;
import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ProbabilityBasedLineGeneratorTest {

    @Test
    public void test_랜덤_라인_사다리_생성() {
        final LadderGenerator ladderGenerator = new ProbabilityBasedLineGenerator(50);
        final int lineSize = 5;

        Ladder ladder = ladderGenerator.generate(lineSize);
        assertThat(ladder.lineSize())
                .isEqualTo(lineSize);
    }
}