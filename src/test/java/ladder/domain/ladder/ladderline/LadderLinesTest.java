package ladder.domain.ladder.ladderline;

import ladder.testutil.LadderLineTestUtil;
import org.junit.jupiter.api.Assertions;
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

    @Test
    void result() {
        LadderLines ladderLines = new LadderLines(List.of(LadderLineTestUtil.continuousLadder()));
        Assertions.assertAll(
                () -> assertThat(ladderLines.result(0)).isEqualTo(1),
                () -> assertThat(ladderLines.result(1)).isEqualTo(0)
        );
    }
}
