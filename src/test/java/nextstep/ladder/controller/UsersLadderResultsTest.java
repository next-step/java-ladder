package nextstep.ladder.controller;

import nextstep.ladder.model.LadderResultsTest;
import nextstep.ladder.model.UsersTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersLadderResultsTest {
    public static final UsersLadderResults USERS_LADDER_RESULTS = UsersLadderResults.of(UsersTest.FOUR_USERS, LadderResultsTest.FOUR_LADDER_RESULTS);

    @Test
    void ofTest() {
        // then
        assertThat(USERS_LADDER_RESULTS).isNotNull();
    }

    @Test
    void sizeTest() {
        // when & then
        assertThat(USERS_LADDER_RESULTS.size()).isEqualTo(UsersTest.FOUR_USERS.size());
    }
}
