package step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import step4.exception.MaximumNameLengthException;
import step4.exception.MinimumNameLengthException;

public class PlayerNameTest {

    @Test
    void 생성_테스트() {
        // given
        PlayerName playerName = new PlayerName("dhlee");
        // when & then
        assertThat(playerName).isEqualTo(new PlayerName("dhlee"));
    }

    @Test
    void 이름길이_유효성_테스트() {
        Assertions.assertThrows(MinimumNameLengthException.class, () -> new PlayerName(""));
        Assertions.assertThrows(MaximumNameLengthException.class, () -> new PlayerName("example"));
    }
}
