package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    public static final Players PLAYERS = new Players(Arrays.asList(PlayerTest.POBI, PlayerTest.HONUX, PlayerTest.JUN, PlayerTest.JK));
    
    @Test
    @DisplayName("여러 플레이어들의 일급 콜렉션 생성")
    void create() {
        assertThat(PLAYERS).isNotNull();
    }
}
