package ladder.domain.ladder;

import static ladder.domain.ladder.Ladder.createLadder;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("사다리 높이를 받아 사다리를 만들 수 있다.")
    void createLadderTest() {

        // given
        LadderHeight height = new LadderHeight(2);
        Line line = new Line(Arrays.asList(new Point(0, true),
            new Point(1, false),
            new Point(2, true),
            new Point(3, false)));
        List<Line> lines = Arrays.asList(line, line);
        Ladder expected = new Ladder(lines);

        // when
        Ladder result = createLadder(height, 4, () -> true);

        // then
        assertThat(result).isEqualTo(expected);
    }

}
