package ladder;

import ladder.domain.*;
import ladder.domain.generator.LadderGenerator;
import ladder.support.FixedLadderGenerator;
import org.junit.Test;

public class LadderGameTest {
    @Test
    public void 높이4_참여자3_사다리게임_플레이_결과() {
        // given
        Ladder ladder = LadderTest.높이4_참여자3_고정사다리_생성하기();
        Players players = Players.valueOfComma("일,이,삼");
        BetItems betItems = BetItems.valueOfComma("1,2,3");

        LadderGenerator ladderGenerator = new FixedLadderGenerator(ladder);
        LadderGame ladderGame = new LadderGame(ladderGenerator);
        ladderGame.init(3, 4);
        // when
        GameResults gameResults = ladderGame.play(players, betItems);
        // then
        System.out.println(gameResults);
    }
}
