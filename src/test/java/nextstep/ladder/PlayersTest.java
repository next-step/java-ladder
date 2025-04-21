package nextstep.ladder;

import ladder.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class PlayersTest {
    @Test
    void 플레이어_최소1명() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Players(Collections.emptyList()));
    }
}
