package laddergame.v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {

    @DisplayName("사다리 게임 플레이어의 이름은 5자 이하만 입력 가능하다")
    @Test
    void limitPlayerName(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("이름5자초과"))
                .withMessage("플레이어의 이름을 5자 이하로 입력해주세요.");
    }

    @DisplayName("동일한 이름의 플레이어인지 확인한다")
    @Test
    void isSameName(){
        Player player = new Player("name");

        assertThat(player.isSameName("name")).isTrue();
    }
}
