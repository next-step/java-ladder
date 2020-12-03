package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
