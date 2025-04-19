package nextstep.ladder;

import ladder.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    void 플레이어_이름수_초과() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("adfdf1"));
    }
}
