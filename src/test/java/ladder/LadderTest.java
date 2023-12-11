package ladder;

import ladder.domain.Ladder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LadderTest {
    private final String FALSE_POINT = "     |";
    private final String TRUE_POINT = "-----|";

    @Test
    void false_true_그림() {
        String result =FALSE_POINT + TRUE_POINT + FALSE_POINT + TRUE_POINT;
        Ladder ladder = new Ladder(Arrays.asList(true, false, true));

        Assertions.assertThat(ladder.ladderDraw()).isEqualTo(result);
    }


}
