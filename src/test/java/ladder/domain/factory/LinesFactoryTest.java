package ladder.domain.factory;

import ladder.domain.Line;
import ladder.domain.Lines;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinesFactoryTest {

    @Test
    void createLines() {

        int ladderWidth = 4;
        int ladderHeight = 5;

        Lines lines = LinesFactory.createLines(ladderWidth, ladderHeight);
        assertThat(lines.getLines()).hasSize(ladderHeight);
        lines.getLines().stream()
            .map(Line::getPoints)
            .forEach(points -> assertThat(points).hasSize(ladderWidth));
    }
}
