package laddergame;

import laddergame.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerTest {

    @DisplayName("Player 생성 테스트")
    @Test
    void PlayerConstructorTest(){
        assertThatIllegalArgumentException().isThrownBy(()->{
            Player player = new Player("abcdef");
        });
    }

}
