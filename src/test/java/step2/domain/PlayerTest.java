package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void setPlayerName() {

        Player player = new Player("일이삼사오");

        assertThat(player.getPlayerName()).isEqualTo("일이삼사오");

    }


    @Test
    void setGameResult() {

        // not implements yet.

    }
}
