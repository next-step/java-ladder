package nextstep.ladder;

import nextstep.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {
    @Test
    @DisplayName("사람의 이름은 5자까지")
    void playerNameLimit() {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> {
            new Players(new String[]{"fiveoverbong", "big"});
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
