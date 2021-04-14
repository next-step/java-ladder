package step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import step4.exception.MinimumNameLengthException;
import step4.exception.NaturalNumberException;

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
        Assertions.assertThrows(MinimumNameLengthException.class, () -> new Player(0, ""));
        Assertions.assertThrows(NaturalNumberException.class, () -> new Player(-1, "test"));
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
