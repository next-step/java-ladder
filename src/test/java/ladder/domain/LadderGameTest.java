package ladder.domain;

import ladder.application.LadderGame;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    @Test
    void start() {
        Ladder ladder = createLadder();
        LadderGameInfo ladderGameInfo = new LadderGameInfo(Users.of("a,b,c"), LadderRewards.of("꽝,당첨,당첨2"));

        LadderGameResults ladderGameResults = LadderGame.start(ladder, ladderGameInfo);

        Map<User, LadderReward> expectedResults = new HashMap<>();
        expectedResults.put(new User("a"), new LadderReward("당첨2"));
        expectedResults.put(new User("b"), new LadderReward("꽝"));
        expectedResults.put(new User("c"), new LadderReward("당첨"));
        assertThat(ladderGameResults).isEqualTo(new LadderGameResults(expectedResults));
    }

    private Ladder createLadder() {
        /*
         *  0   1   2
         *  |---|   |
         *  |   |---|
         */
        return new Ladder(Arrays.asList(
                new LadderLine(Arrays.asList(
                        new Point(0, Direction.of(FALSE, TRUE)),
                        new Point(1, Direction.of(TRUE, FALSE)),
                        new Point(2, Direction.of(FALSE, FALSE))
                )),
                new LadderLine(Arrays.asList(
                        new Point(0, Direction.of(FALSE, FALSE)),
                        new Point(1, Direction.of(FALSE, TRUE)),
                        new Point(2, Direction.of(TRUE, FALSE))
                ))
        ), 3);
    }
}
