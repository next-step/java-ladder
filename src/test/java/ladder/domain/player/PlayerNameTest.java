package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerNameTest {

    @DisplayName("이름이 5자 초과면 Name 생성 실패")
    @Test
    void create_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerName("chicken"))
                .withMessage("이름은 5자이하 이어야 합니다");
    }
}
