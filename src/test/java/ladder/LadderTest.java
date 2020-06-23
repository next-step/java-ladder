package ladder;

import ladder.domain.*;
import ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("사다리 높이 테스트")
    @Test
    void getLadderHeightSize() {
        assertThat(new Ladder(5, 2).getLineHeight()).isEqualTo(5);
    }

    @DisplayName("사다리 타기 결과 테스트")
    @Test
    void getResultPositionTest() {

        Players players = new Players("iu,iu2,iu3,iu4");
        Ladder ladder = new Ladder(3, players.getPlayerCount());
        String reulstsString = "1,2,3,4";
        Rewards rewards = new Rewards(reulstsString);
        LadderResultOutput output = ladder.playLadderGame(players, rewards);

        for (int i = 0; i < rewards.getResultCount(); i++) {
            assertThat(output.getResultTargetOutput(players.getPlayerName(i))).isNotNull();
        }

        StringBuilder sb = new StringBuilder();
        output.getResultOutput().forEach((name, reward) -> {
            sb.append(name + ":" + reward + "\n");
        });
        System.out.println(sb.toString());

    }


    @DisplayName("사다리 타기 출력")
    @Test
    void displayLadderUiTest() {

        Players players = new Players("iu,iu2,iu3,iu4");
        Ladder ladder = new Ladder(3, players.getPlayerCount());
        for (int i = 0; i < ladder.getLineHeight(); i++) {
            System.out.println(ladder.getDrawLine(i));
        }
        ResultView rv = new ResultView();
        rv.displayLadder(ladder);
    }
}