package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void testCreateLadder() {
        Ladder ladder = new Ladder(5, 3);
        List<Line> lines = ladder.getLines();

        assertThat(lines).size().isEqualTo(5);
        assertThat(lines).allMatch((line) -> line.getPointSize() == 3);
    }

}
