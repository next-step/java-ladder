package ladder.domain.player;

import ladder.domain.player.Name;
import ladder.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {

    @DisplayName("null 입력 예외 발생")
    @Test
    void createNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Player.create(null));
    }

    @DisplayName("입력한 이름을 반환")
    @Test
    void getName() {
        Player player = Player.create(Name.valueOf("ABC"));
        assertThat(player.getName()).isEqualTo(Name.valueOf("ABC"));
    }
}
