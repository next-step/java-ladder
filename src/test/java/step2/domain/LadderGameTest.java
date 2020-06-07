package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    void setPlayerList() {

        LadderGame ladderGame = new LadderGame();
        ladderGame.setPlayerList("A,B,C".split(","));

        assertThat(ladderGame.getPlayerList().size()).isEqualTo(3);



    }

    @Test
    void setLaddersHeight() {


        LadderGame ladderGame = new LadderGame();

        ladderGame.setPlayerList("A,B,C".split(","));

        ladderGame.setLaddersHeight(5);


        assertThat(ladderGame.getLadders().getLadderList().get(0).getLineCount()).isEqualTo(5);

    }
}
