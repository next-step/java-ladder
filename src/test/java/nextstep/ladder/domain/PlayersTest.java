package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

    @Test
    void 정상적으로_플레이어_목록이_생성된다() {
        Players players = new Players("pobi,honux,crong");
        List<Player> list = players.getPlayers();
        assertEquals(3, list.size());
        assertEquals("pobi", list.get(0).getName());
    }

    @Test
    void 빈_이름이_있으면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Players("pobi,,honux"));
    }

    @Test
    void 숫자_이름이_있으면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Players("pobi,1234,honux"));
    }
}
