package ladder;

import ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    @DisplayName("플레이어 생성 실패 테스트")
    void validateTest() {
        assertThatThrownBy(
                () -> Player.of("jojaeasdfasdf", 1)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
