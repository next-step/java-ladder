package ladder;

import ladder.domain.Player;
import ladder.domain.Players;
import ladder.exception.PlayerException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    void 플레이어들_생성() {
        Players players = new Players("p1, p2, p3, p4, p5");
        Assertions.assertThat(players.getCount()).isEqualTo(5);
    }

    @Test
    void 플레이어_이름_5자_이하() {
        Assertions.assertThatThrownBy(() -> new Player("다섯글자이상")).isInstanceOf(PlayerException.class);
    }
}
