package ladder.service;

import ladder.domain.LadderGame;
import ladder.domain.LadderMoveStrategy;
import ladder.domain.WayTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderServiceTest {

    private LadderGame game;
    private LadderService service;

    @BeforeEach
    void setUp() {
        String inputName = "a,b,c";
        String inputHeight = "2";
        String inputPrize = "100,200,300";
        LadderMoveStrategy strategy = WayTest.strategyTrue;
        service = new LadderService();
        game = service.createLadderGame(inputName, inputHeight, inputPrize, strategy);
    }

    @DisplayName("사용자의 입력을 받고 해당 정보를 이용해 사다리를 생성한다.")
    @Test
    public void createLadderGame_success() throws Exception {
        //then
        assertThat(game.getPlayers().size()).isEqualTo(3);
        assertThat(game.getLadder().getLadderPrize().size()).isEqualTo(3);
        assertThat(game.getLadder().getLines().getStartPointCount()).isEqualTo(3);
        assertThat(game.getLadder().getLines().getLines().size()).isEqualTo(2);
    }

    @DisplayName("사다리 게임 참여자의 게임 결과를 확인")
    @Test
    public void startGameOfPlayer_success() throws Exception {
        //when
        Map<String, String> a = service.startGameOfPlayer("a", game);
        Map<String, String> b = service.startGameOfPlayer("b", game);
        Map<String, String> all = service.startGameOfPlayer("all", game);

        //then
        assertThat(a.keySet()).contains("a");
        assertThat(b.keySet()).contains("b");
        assertThat(all.keySet()).contains("a", "b", "c");
        assertThat(a.get("a")).contains("100");
        assertThat(b.get("b")).contains("200");
    }
}
