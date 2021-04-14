package step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ladder.domain.PlayerName;

public class PlayerNameTest {

    @Test
    void 생성_테스트() {
        // given
        ladder.domain.PlayerName playerName = new ladder.domain.PlayerName("dhlee");
        // when & then
        assertThat(playerName).isEqualTo(new ladder.domain.PlayerName("dhlee"));
    }

    @Test
    void 이름길이_유효성_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ladder.domain.PlayerName(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PlayerName("example"));
    }
}
