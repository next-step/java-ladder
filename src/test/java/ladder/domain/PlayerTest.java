package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {

    @DisplayName("Player 생성 테스트")
    @Test
    void playerConstructorTest(){
        // given
        String playerName = "AAA";

        // when
        Player player = new Player(playerName);

        // then
        assertThat(player.getName()).isEqualTo(playerName);
    }


    @DisplayName("Player 이름 유효성 테스트")
    @Test
    void illegalPlayerNameExceptionTest(){

        assertThatIllegalArgumentException().isThrownBy(() -> {

            String playerName = "christoper";

            new Player(playerName);

        }).withMessageContaining(LadderGameErrorMessage.ILLEGAL_MAX_PLAYER_NAME.getErrorMessage());
    }
}
