package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void test() {
        String[] inputs = "sia,kim,gcc,eric".split(",");
        int height = 5;
        Ladder ladder = new Ladder();
        ladder.makeLines(inputs, height);

        assertThat(ladder.getLines().size()).isEqualTo(5);

    }
}
