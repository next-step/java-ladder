package nextstep.ladder.controller;

import nextstep.ladder.model.User;
import nextstep.ladder.model.UserName;
import nextstep.ladder.model.Users;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RunRequestTest {
    private static final List<String> USER_NAMES = Arrays.asList("pobi", "honux", "crong", "jk");

    @Test
    void ofTest() {
        // when
        RunRequest request = RunRequest.of(USER_NAMES, 5);
        // then
        assertThat(request).isNotNull();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void checkExceptionForInvalidUserNamesTest(List<String> userNames) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> RunRequest.of(userNames, 5)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void checkExceptionForInvalidHeightOfLadderTest(int heightOfLadder) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> RunRequest.of(USER_NAMES, heightOfLadder)
        );
    }

    @Test
    void participatedUsersTest() {
        // given
        RunRequest request = RunRequest.of(USER_NAMES, 5);
        // when
        Users users = request.participatedUsers();
        // then
        assertThat(users.getUsers())
                .extracting(User::getName)
                .isEqualTo(USER_NAMES);
    }

    @Test
    void getHeightOfLadderTest() {
        // given
        int heightOfLadder = 5;
        RunRequest request = RunRequest.of(USER_NAMES, heightOfLadder);
        // when & then
        assertThat(request.getHeightOfLadder()).isEqualTo(heightOfLadder);
    }
}
