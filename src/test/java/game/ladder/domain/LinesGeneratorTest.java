package game.ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesGeneratorTest {

    @Test
    public void 라인_만들기() {
        final int blockSize = 3;
        final Height height = new Height(3);
        LinesGenerator generator = new LinesGenerator(height);

        Lines lines = generator.generate(blockSize);

        assertThat(lines.getHeight()).isEqualTo(height);
    }



}