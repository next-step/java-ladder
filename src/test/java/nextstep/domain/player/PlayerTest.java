package nextstep.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    @DisplayName("참여자 객체를 생성할 수 있다.")
    void init() {
        Player player = new Player("test");
        assertEquals(player.getPlayerName(), "test");
    }

    @Test
    @DisplayName("참여자가 2명 미만인 경우 예외가 발생한다.")
    void checkValidPlayersCount() {
        Player player = new Player("test");
        assertThatThrownBy(() -> new Players(List.of(player)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}