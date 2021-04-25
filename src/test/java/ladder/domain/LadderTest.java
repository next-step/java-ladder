package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderTest {
    @Test
    public void create() {
        final int width = 5;

        final List<LadderLine> ladderLines = Arrays.asList(
                LadderLine.from(width),
                LadderLine.from(width),
                LadderLine.from(width),
                LadderLine.from(width)
        );

        assertThatCode(() -> new Ladder(ladderLines))
                .doesNotThrowAnyException();
    }
}
