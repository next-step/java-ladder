package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ladder.domain.Player;

public class PlayerTest {

    @Test
    void 생성_테스트() {
        String test = "dhlee";
        Player player = new Player(test, 0);
        assertThat(player).isEqualTo(new Player(" dhlee  ", 0));
    }


    @Test
    void 생성_유효성_테스트() {
        String test = " ";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Player(test, 0));
    }
}
