package ladder.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    public void 여러_줄_생성() {
        // given
        final Line line = new Line.Builder(false).build();

        // when
        final Lines lines = new Lines(Arrays.asList(line));

        // then
        assertThat(lines.getHeight()).isEqualTo(1);
    }

    @Test
    public void 줄_꺼내기() {
        // given
        final Line line = new Line.Builder(false).build();

        // when
        final Lines lines = new Lines(Arrays.asList(line));

        // then
        assertThat(lines.getLine(0)).isNotNull();
    }
}