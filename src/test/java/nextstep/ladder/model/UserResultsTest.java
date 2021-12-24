package nextstep.ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserResultsTest {
    private static final UserResults USER_RESULTS = UserResults.from(Arrays.asList(UserResultTest.USER_RESULT_WITH_BANG, UserResultTest.USER_RESULT_WITH_2000_WON));

    @Test
    void fromTest() {
        // when & then
        assertThat(USER_RESULTS).isNotNull();
    }
}
