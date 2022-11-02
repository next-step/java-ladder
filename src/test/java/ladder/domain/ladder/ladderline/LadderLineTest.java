package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.HorizontalLineDirection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class LadderLineTest {

    @Test
    void create() {
        LadderLine ladderLine = new LadderLine(List.of(HorizontalLineDirection.NONE, HorizontalLineDirection.NONE));

        assertThat(ladderLine)
                .isEqualTo(new LadderLine(List.of(HorizontalLineDirection.NONE, HorizontalLineDirection.NONE)));
    }
}
