package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    void When_Result_Then_() {
        Line firstLine = new Line(Arrays.asList(Link.CLOSE, Link.OPEN));
        Line secondtLine = new Line(Arrays.asList(Link.OPEN, Link.CLOSE));
        Ladder ladder = new Ladder(Arrays.asList(firstLine, secondtLine));

        Players players = new Players(Arrays.asList("fir", "sed", "thr"));
        Goals goals = new Goals(Arrays.asList("1", "2", "3"));

        LadderResult ladderResult = ladder.result(players, goals);

        assertThat(ladderResult.result("fir").get(0).goal()).isEqualTo("3");
        assertThat(ladderResult.result("sed").get(0).goal()).isEqualTo("1");
        assertThat(ladderResult.result("thr").get(0).goal()).isEqualTo("2");
    }
}
