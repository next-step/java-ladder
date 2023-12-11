package ladder;

import ladder.domain.LadderGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ladder.util.StringUtil.split;

public class LaddersGameTest {
    @Test
    void LadderGame높이() {
        String testNames = "qwert,aaaafz,,asdv";

        Assertions.assertThatThrownBy(() -> new LadderGame(split(testNames), 4)).isInstanceOf(IllegalArgumentException.class);
    }
}
