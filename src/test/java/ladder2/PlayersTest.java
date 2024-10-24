package ladder2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    void 플레이어는_2명_이상이어야_한다() {
        assertThatThrownBy(() -> new Players("didi"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어_수를_반환한다() {
        Players players = new Players("didi", "bibi", "ppii");
        int size = players.size();

        assertThat(size).isEqualTo(3);
    }
}
