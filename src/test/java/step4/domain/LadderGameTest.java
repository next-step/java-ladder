package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @DisplayName(",를 구분으로 게임 플레이어를 입력하여 정상적인 플레이서 수, 사다리 높이 판단")
    @Test
    void setPlayerList() {
        // set players
        //List<Player> playerList = new ArrayList<>();
        List<Player> playerList = Arrays.asList(new Player("A"),
                new Player("B"), new Player("C"));
        Players players = new Players(playerList);
        // winning list
        List<String> winningList = Arrays.asList("1", "2", "X");
        WinningPrizes winningPrizes = new WinningPrizes(winningList);
        LadderGame ladderGame = LadderGame.createLadder(players, winningPrizes, 4);
        assertThat(ladderGame.getPlayers().size()).isEqualTo(3);
        assertThat(ladderGame.getLadders().getLadderList().size()).isEqualTo(3);
        assertThat(ladderGame.getLadders().getLadderList().get(0).getLineCount()).isEqualTo(4);
    }

}
