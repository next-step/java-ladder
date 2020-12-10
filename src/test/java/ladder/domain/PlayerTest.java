package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {

    private static final int PLAYER_NAME_MAX_LENGTH = 5;

    @DisplayName("Player 생성 테스트")
    @Test
    void playerConstructorTest(){
        // given
        String playerName = "AAA";

        // when
        Player player = Player.from(playerName);

        // then
        assertThat(player.getName()).isEqualTo(playerName);
    }


    @DisplayName("Player 이름 유효성 테스트")
    @Test
    void illegalPlayerNameExceptionTest(){

        assertThatIllegalArgumentException().isThrownBy(() -> {

            String playerName = "christoper";

            Player.from(playerName);

        }).withMessageContaining("참여할 사람의 이름은 최대 "+PLAYER_NAME_MAX_LENGTH+" 글자 입니다.");
    }
}
