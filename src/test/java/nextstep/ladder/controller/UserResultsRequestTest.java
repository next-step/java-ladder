package nextstep.ladder.controller;

import nextstep.ladder.model.LadderResultsTest;
import nextstep.ladder.model.UsersTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserResultsRequestTest {
    public static final UserResultsRequest USER_RESULTS_REQUEST = UserResultsRequest.of(UsersTest.FOUR_USERS, LadderResultsTest.FOUR_LADDER_RESULTS);

    @Test
    void ofTest() {
        // then
        assertThat(USER_RESULTS_REQUEST).isNotNull();
    }

    @Test
    void sizeTest() {
        // when & then
        assertThat(USER_RESULTS_REQUEST.size()).isEqualTo(UsersTest.FOUR_USERS.size());
    }
}
