package domain;

import domain.bridge.TestBridgeGenerator;
import domain.ladder.Goals;
import domain.ladder.Ladder;
import domain.result.Results;
import domain.user.Users;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void 한명_결과확인() {
        //given
        int height = 3;
        int userCount = 4;
        String names = "pobi,honux,crong,jk";
        Users users = new Users(names);
        Ladder ladder = new Ladder(height, userCount, new TestBridgeGenerator());

        Goals goals = new Goals("꽝,5000,꽝,3000");

        //when
        String name = "pobi";
        LadderGame ladderGame = new LadderGame(ladder, users);
        Results result = ladderGame.result(name, goals);

        //then
        assertThat(result.findOne(name)).isEqualTo("5000");
    }

    @Test
    public void 전체결과보기() {
        //given
        int height = 3;
        int userCount = 4;
        String names = "pobi,honux,crong,jk";
        Users users = new Users(names);
        Ladder ladder = new Ladder(height, userCount, new TestBridgeGenerator());

        Goals goals = new Goals("꽝,5000,꽝,3000");

        //when
        String name = "all";
        LadderGame ladderGame = new LadderGame(ladder, users);
        Results result = ladderGame.result(name, goals);

        //then
        assertThat(result.findOne(users.getUserName(0))).isEqualTo(goals.findGoal(1));
        assertThat(result.findOne(users.getUserName(1))).isEqualTo(goals.findGoal(0));
        assertThat(result.findOne(users.getUserName(2))).isEqualTo(goals.findGoal(3));
        assertThat(result.findOne(users.getUserName(3))).isEqualTo(goals.findGoal(2));
    }
}