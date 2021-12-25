package nextstep.ladder.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserResultsTest {
    private static final UserResults USER_RESULTS = UserResults.from(Arrays.asList(UserResultTest.CRONG_USER_RESULT_WITH_BANG, UserResultTest.POBI_USER_RESULT_WITH_2000_WON));

    @Test
    void fromTest() {
        // when & then
        assertThat(USER_RESULTS).isNotNull();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void checkExceptionForInvalidUserResultsTest(List<UserResult> invalidUserResults) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> UserResults.from(invalidUserResults)
        );
    }
}
