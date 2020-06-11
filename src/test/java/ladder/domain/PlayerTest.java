package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Player 클래스 테스트")
class PlayerTest {

    @DisplayName("참가지 이름을 가지는 Player를 생성할 수 있다.")
    @Test
    void create_player_have_name() {
        String name = "jun";
        Player player = new Player(name);

        assertThat(player.getName()).isEqualTo(name);
    }
}
