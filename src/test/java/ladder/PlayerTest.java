package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ladder.domain.Player;
import ladder.domain.PlayerName;

public class PlayerTest {

    @Test
    void 생성_테스트() {
        // given
        String test = "dhlee";
        Player player = new Player(0, test);
        // when & then
        assertThat(player).isEqualTo(new Player(0, " dhlee  "));
    }


    @Test
    void 생성_유효성_테스트() {
        // given
        String test = " ";
        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Player(0, test));
    }

    @Test
    void 이름_동일_여부_테스트() {
        // given
        String test = "dhlee";
        Player player = new Player(0, test);
        // when & then
        assertThat(player.isNameEqual(new PlayerName("dhlee"))).isTrue();
        assertThat(player.isNameEqual(new PlayerName("test"))).isFalse();
    }
}
