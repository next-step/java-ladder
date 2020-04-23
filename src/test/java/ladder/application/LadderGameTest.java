package ladder.application;

import ladder.domain.*;
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
        User userA = new User("a");
        User userB = new User("b");
        User userC = new User("c");
        LadderReward ggang = new LadderReward("꽝");
        LadderReward lucky = new LadderReward("당첨");
        LadderReward lucky2 = new LadderReward("당첨2");
        LadderGameInfo ladderGameInfo = new LadderGameInfo(new Users(Arrays.asList(userA, userB, userC)),
                new LadderRewards(Arrays.asList(ggang, lucky, lucky2)));

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
        ));
    }
}
