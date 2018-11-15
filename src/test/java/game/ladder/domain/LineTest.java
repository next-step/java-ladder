package game.ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 만들기() {
        final int blockSize = 3;
        Line line = new Line(blockSize);
        assertThat(line.getBlockSize()).isEqualTo(blockSize);
    }

}