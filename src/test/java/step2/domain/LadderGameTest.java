package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @DisplayName(",를 구분으로 게임 플레이어를 입력하여 정상적인 플레이서 수 판단")
    @Test
    void setPlayerList() {
        LadderGame ladderGame = new LadderGame();
        ladderGame.setPlayerList("A,B,C".split(","));

        assertThat(ladderGame.getPlayerList().size()).isEqualTo(3);
    }

    @DisplayName("사다리 높이 입력값 과 실제 생성된 Lines Count 비교")
    @Test
    void setLaddersHeight() {
        LadderGame ladderGame = new LadderGame();
        ladderGame.setPlayerList("A,B,C".split(","));
        ladderGame.setLaddersHeight(5);

        assertThat(ladderGame.getLadders().getLadderList().get(0).getLineCount()).isEqualTo(5);
    }

}
