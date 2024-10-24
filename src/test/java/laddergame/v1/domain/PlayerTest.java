package laddergame.v1.domain;

import laddergame.v1.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {

    @DisplayName("사다리 게임 플레이어의 이름은 5자 이하만 입력 가능하다")
    @Test
    void limitPlayerName(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("이름5자초과", 0))
                .withMessage("플레이어의 이름을 5자 이하로 입력해주세요.");
    }

}