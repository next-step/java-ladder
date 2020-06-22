package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Player;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @DisplayName("Player 개체 생성")
    @Test
    void setPlayerName() {
        Player player = new Player("일이삼사오");
        assertThat(player.getPlayerName()).isEqualTo("일이삼사오");
    }


}
