package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultLinesGeneratorTest {
    @Test
    public void 라인_생성() {
        // given
        final int numberOfPlayers = 4;
        final int height = 5;
        final LinesGenerator linesGenerator = new DefaultLinesGenerator(numberOfPlayers, height);

        // when
        final Lines lines = linesGenerator.generate();

        // then
        assertThat(lines.getHeight()).isEqualTo(height);
    }
}