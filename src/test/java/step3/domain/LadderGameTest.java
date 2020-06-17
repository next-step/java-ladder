package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @DisplayName(",를 구분으로 게임 플레이어를 입력하여 정상적인 플레이서 수, 사다리 높이 판단")
    @Test
    void setPlayerList() {
        // set players
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("A"));
        playerList.add(new Player("B"));
        playerList.add(new Player("C"));
        Players players = new Players(playerList);
        // winning list
        List<String> winningList = new ArrayList<>();
        winningList.add("1");
        winningList.add("2");
        winningList.add("X");
        WinningPrizes winningPrizes = new WinningPrizes(winningList);
        LadderGame ladderGame = LadderGame.createLadder(players, winningPrizes, 4);
        assertThat(ladderGame.getPlayers().size()).isEqualTo(3);
        assertThat(ladderGame.getLadders().getLadderList().size()).isEqualTo(3);
        assertThat(ladderGame.getLadders().getLadderList().get(0).getLineCount()).isEqualTo(4);
    }

}
