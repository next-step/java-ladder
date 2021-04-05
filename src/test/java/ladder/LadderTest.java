package ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderTest {
    @Test
    void When_New_Then_Created() {
        Linker linker = new Linker(() -> Link.OPEN);
        assertDoesNotThrow(() -> {
            new Ladder(5, 5, linker);
        });
    }

    @Test
    void When_Line_Then_LineSizeIsEqualToHeight() {
        Linker linker = new Linker(() -> Link.OPEN);
        Ladder ladder = new Ladder(5, 3, linker);

        List<Line> line = ladder.line();
        assertThat(line.size()).isEqualTo(5);
    }
}
