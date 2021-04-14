package step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import step4.exception.MinimumNameLengthException;

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
        Assertions.assertThrows(MinimumNameLengthException.class, () -> new Player(0, test));
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
