package ladder;

import ladder.domain.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ladder.util.StringUtil.split;

public class PlayersTest {
    @Test
    void 이름_길이() {
        String testNames = "qwert,aaaafz,,asdv";

        Assertions.assertThatThrownBy(() -> new Players(split(testNames))).isInstanceOf(IllegalArgumentException.class);
    }

}
