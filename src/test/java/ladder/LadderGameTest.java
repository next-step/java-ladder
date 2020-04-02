package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    @Test
    @DisplayName("게임 생성 테스트")
    void createGameTest() {
        new LadderGame("jojo, haha");
    }

    @Test
    @DisplayName("게임 생성 실패 테스트")
    void validateNamesTest() {
        assertThatThrownBy(
                () -> new LadderGame("jojoasdfasd, haha")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
