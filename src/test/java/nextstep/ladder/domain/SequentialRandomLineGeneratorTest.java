package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SequentialRandomLineGeneratorTest {

    private final LineGenerator lineGenerator = new SequentialRandomLineGenerator();

    @Test
    public void generateBridges_다리_개수_확인() {
        assertThat(lineGenerator.generateBridges(5)).hasSize(4);
    }
}
