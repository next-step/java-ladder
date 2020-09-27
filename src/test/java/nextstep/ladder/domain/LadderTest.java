package nextstep.ladder.domain;

import nextstep.ladder.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LadderTest {

    @Test
    @DisplayName("사다리타기 결과를 제공한다")
    void ladderResultTest() {
        String personsRaw = "a,bb,ccc,dd";
        Users users = Users.ofByRaw(personsRaw);

        Ladder ladder = Ladder.random(users.countOfUsers(), 5);
        Result result = new Result(Arrays.asList("r1", "r2", "r3", "r4"));
        OutputView.drawLadderGame(ladder, users, result);
        ladder.getResultByUserOrder(0);
    }

}