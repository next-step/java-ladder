package nextstep.ladder.model;

import nextstep.ladder.controller.UsersLadderResultsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    public static final LadderGame LADDER_GAME = new LadderGame(LadderTest.LADDER, UsersLadderResultsTest.USERS_LADDER_RESULTS);

    @Test
    void createTest() {
        // given
        assertThat(LADDER_GAME).isNotNull();
    }

    @Test
    void userResultsTest() {
        // when
        UserResults userResults = LADDER_GAME.userResults();
        // then
        assertThat(userResults).isNotNull();
    }
}
