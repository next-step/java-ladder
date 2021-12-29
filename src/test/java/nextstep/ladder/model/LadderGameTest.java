package nextstep.ladder.model;

import nextstep.ladder.controller.UserLadderResultsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameTest {
    public static final LadderGame LADDER_GAME = new LadderGame(LadderTest.LADDER, UserLadderResultsTest.USERS_LADDER_RESULTS);

    @Test
    void createTest() {
        // given
        assertThat(LADDER_GAME).isNotNull();
    }

    @Test
    void checkExceptionForInvalidLadderTest() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LadderGame(null, UserLadderResultsTest.USERS_LADDER_RESULTS)
        );
    }

    @Test
    void checkExceptionForInvalidUsersLadderResultsTest() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LadderGame(LadderTest.LADDER, null)
        );
    }

    @Test
    void userResultsTest() {
        // when
        UserResults userResults = LADDER_GAME.userResults();
        // then
        assertThat(userResults).isNotNull();
    }
}
