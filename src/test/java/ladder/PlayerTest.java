package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ladder.domain.Player;

public class PlayerTest {

    @Test
    void 생성_테스트() {
        String test = "dhlee, pobi, gisun";
        Player player = new Player(test);
        assertThat(player.getNames().size()).isEqualTo(3);
    }


    @Test
    void 생성_유효성_테스트() {
        String test = "dhlee, ,gisun";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Player(test));
    }
}
