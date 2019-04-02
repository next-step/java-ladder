package generator.ladders.impl;

import domain.ladder.Ladders;
import generator.ladders.LaddersGenerator;
import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ProbabilityBasedLineGeneratorTest {

    @Test
    public void test_랜덤_라인_사다리목록_생성() {
        LaddersGenerator laddersGenerator = new ProbabilityBasedLineGenerator((50));
        int height = 5;

        Ladders ladders = laddersGenerator.generate(height, 4);
        assertThat(ladders.height())
                .isEqualTo(height);
    }
}