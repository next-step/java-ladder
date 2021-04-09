package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ladder.domain.Player;
import ladder.domain.Players;

public class PlayersTest {
    @Test
    void 생성_테스트() {
        // given
        Players players = new Players("dhlee, test1, test2");
        // when & then
        assertThat(players.playerCount()).isEqualTo(3);
    }

    @Test
    void 생성_유효성_테스트() {
        // given
        String test = "dhlee, ,gisun";
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Players(test));
    }

    @Test
    void 생성_중복_테스트() {
        // given
        String test = "dhlee, dhlee";
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Players(test));
    }

    @Test
    void 참가자_찾기_테스트() {
        // given
        Players players = new Players("dhlee, test1, test2");
        // when & then
        assertThat(players.findPlayer("dhlee")).isEqualTo(new Player(0, "dhlee"));
        assertThat(players.findPlayer("test1")).isEqualTo(new Player(1, "test1"));
        assertThat(players.findPlayer("test2")).isEqualTo(new Player(2, "test2"));
    }
}
