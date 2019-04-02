package generator.ladder.impl;

import domain.ladder.Ladders;
import generator.bool.impl.ProbabilityBasedGenerator;
import generator.ladder.LaddersGenerator;
import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLineLaddersGeneratorTest {

    @Test
    public void test_랜덤_라인_사다리_생성() {
        LaddersGenerator laddersGenerator = new RandomLineLaddersGenerator(new ProbabilityBasedGenerator(50));
        int height = 5;

        Ladders ladders = laddersGenerator.generate(height, 4);
        assertThat(ladders.height())
                .isEqualTo(height);
    }
}