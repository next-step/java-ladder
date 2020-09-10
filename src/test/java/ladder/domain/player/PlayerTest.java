package ladder.domain.player;

import ladder.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("플레이어 이름이 5글자 이상일 경우 예외 테스트")
    public void name_length_over_exception_test() {
        // given
        String name = "abcdef";
        int position = 2;

        // when & then
        assertThatThrownBy(() -> Player.builder()
                .name(name)
                .position(position)
                .build())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자까지 가능합니다." + name);
    }
}
