package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("Player 개체 생성")
    @Test
    void setPlayerName() {

        Player player = new Player("일이삼사오");

        assertThat(player.getPlayerName()).isEqualTo("일이삼사오");

    }

    @DisplayName("게임 결과 판단")
    @Test
    void setGameResult() {

        // not implements yet.

    }
}
