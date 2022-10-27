package ladder.domain.ladder.ladderline;

import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.testutil.LadderLineTestUtil.createNoneLadderLine;
import static org.assertj.core.api.Assertions.*;

public class LadderLinesTest {

    @Test
    void create() {
        LadderLines ladderLines = new LadderLines(List.of(createNoneLadderLine(2)));

        assertThat(ladderLines).isEqualTo(new LadderLines(List.of(createNoneLadderLine(2))));
    }
}
