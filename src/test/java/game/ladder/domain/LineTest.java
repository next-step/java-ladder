package game.ladder.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 만들기() {
        final int blockSize = 3;
        Line line = new Line(blockSize);
        assertThat(line.getBlockSize()).isEqualTo(blockSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 만들기_0넣을때() {
        final int blockSize = 0;

        new Line(blockSize);
    }

}