package nextstep.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    @DisplayName("참여자 객체를 생성할 수 있다.")
    void init() {
        Player player = new Player("test");
        assertEquals(player.getPlayerName(), "test");
    }
}