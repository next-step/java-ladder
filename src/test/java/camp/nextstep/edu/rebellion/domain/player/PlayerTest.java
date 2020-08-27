package camp.nextstep.edu.rebellion.domain.player;

import camp.nextstep.edu.rebellion.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @DisplayName("참가자의 이름이 5글자 이상일 경우 예외 발생")
    @Test
    public void nameLengthThrownTest() {
        // given
        String name = "123456";
        int position = 1;

        // when & then
        assertThatThrownBy(() -> new Player(name, position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자의 이름은 최대 5글자 입니다 " + name);
    }
}
