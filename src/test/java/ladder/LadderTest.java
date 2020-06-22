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

//        for (int i = 0; i < ladder.getLineHeight(); i++) {
//            LadderLine ladderLine = ladder.getDrawLine(i);
//            System.out.println(ladder.getDrawLine(i));
//            for (int j =0; j < ladderLine.getLineSize(); j++) {
//                ladderLine.move(j);
//            }
//        }

//        ladder.playLadderGame(players);
//
//        String reulstsString = "꽝,꽝,5000원,5000";
//        Rewards rewards = new Rewards(reulstsString);
//        LadderResultOutput output = new LadderResultOutput(players, rewards);
//
//        for (int i = 0; i < rewards.getResultCount(); i++) {
//            assertThat(output.getResultOutput().get(players.getPlayerName(i))).isEqualTo(rewards.getRewardInfo(i));
//        }

    }


    @DisplayName("사다리 타기 결과 테스트")
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

/**
 *
 * {
 *    "points="[
 *       "Point"      {
 *          index=0,
 *          "direction=Direction"{
 *             "left=false",
 *             "right=true"
 *          }
 *       },
 *       "Point"      {
 *          index=1,
 *          "direction=Direction"{
 *             "left=true",
 *             "right=false"
 *          }
 *       },
 *       "Point"      {
 *          index=2,
 *          "direction=Direction"{
 *             "left=false",
 *             "right=false"
 *          }
 *       },
 *       "Point"      {
 *          index=3,
 *          "direction=Direction"{
 *             "left=false",
 *             "right=false"
 *          }
 *       }
 *    ]
 * }*/