package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("사다리 게임에 참가하는 플레이어 생성")
    void createPlayer() {
        Player wang = new Player(new PlayerName("wang"));
        assertThat(wang).isEqualTo(new Player(new PlayerName("wang")));
    }
}
