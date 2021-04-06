package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Link;
import ladder.domain.Linker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderTest {
    @Test
    void When_New_Then_Created() {
        assertDoesNotThrow(() -> {
            new Ladder(5, 5, () -> Link.OPEN);
        });
    }

    @Test
    void When_Line_Then_LineSizeIsEqualToHeight() {
        Ladder ladder = new Ladder(5, 3, () -> Link.OPEN);

        List<Line> line = ladder.lines();
        assertThat(line.size()).isEqualTo(5);
    }
}
