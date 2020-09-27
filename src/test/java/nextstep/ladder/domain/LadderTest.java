package nextstep.ladder.domain;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;
import nextstep.ladder.view.UsersRaw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리타기 결과를 제공한다")
    void ladderResultTest() {
        String personsRaw = "a,bb,ccc,dd";
        Users users = UsersRaw.createUsers(personsRaw);

        Ladder ladder = Ladder.random(users.countOfUsers(), 5);
        OutputView.drawLadder(ladder, users);
        ladder.getResultOfUser(0);

    }

}