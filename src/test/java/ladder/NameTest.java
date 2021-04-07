package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ladder.domain.PlayerName;

public class NameTest {

    @Test
    void 생성_테스트() {
        // given
        PlayerName playerName = new PlayerName("dhlee");
        // when & then
        assertThat(playerName).isEqualTo(new PlayerName("dhlee"));
    }

    @Test
    void 이름길이_유효성_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PlayerName(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PlayerName("example"));
    }
}
