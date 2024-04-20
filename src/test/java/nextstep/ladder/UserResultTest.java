package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.result.UserResult;
import nextstep.ladder.domain.result.UserResults;
import nextstep.ladder.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserResultTest {

    @Test
    @DisplayName("User result Test")
    void userResultTest() {
        /*
        *   |-----|     |-----|
            |     |-----|     |
            |-----|     |     |
            |     |-----|     |
            |-----|     |-----|
         */
        Users users = Users.of("pobi", "crong", "honux", "jk");

        Ladder ladder = Ladder.of(
            List.of(
                Line.of(true, false, true),
                Line.of(false, true, false),
                Line.of(true, false, false),
                Line.of(false, true, false),
                Line.of(true, false, true)
            )
        );
        LadderResult ladderResult = LadderResult.of("꽝", "5000", "꽝", "3000");

        UserResults userResults = UserResults.of(
            UserResult.of("pobi","꽝"),
            UserResult.of("crong","3000"),
            UserResult.of("honux","꽝"),
            UserResult.of("jk","5000")
        );
        assertThat(ladder.createUserResults(users, ladderResult)).isEqualTo(userResults);
    }
}
