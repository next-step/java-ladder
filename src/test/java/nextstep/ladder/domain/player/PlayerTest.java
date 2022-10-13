package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @DisplayName("문자열 이름으로 플레이어를 생성할 수 있다.")
    @Test
    void player() {
        assertDoesNotThrow(() -> new Player("test"));
    }

    @DisplayName("일급 객체로 플레이어를 생성할 수 있다.")
    @Test
    void playerOfName() {
        assertDoesNotThrow(() -> new Player(Name.of("test")));
    }

    @DisplayName("이름이 같으면 같은 플레이어로 간주한다.")
    @Test
    void equalsPlayer() {
        assertThat(new Player("test")).isEqualTo(new Player("test"));
    }
}