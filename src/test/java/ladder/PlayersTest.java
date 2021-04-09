package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ladder.domain.Players;

public class PlayersTest {
    @Test
    void 생성_테스트() {
        Players players = new Players("dhlee, test1, test2");
        assertThat(players.playerCount()).isEqualTo(3);
    }

    @Test
    void 생성_유효성_테스트() {
        String test = "dhlee, ,gisun";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Players(test));
    }
}
