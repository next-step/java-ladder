package nextstep.ladder.controller;

import nextstep.ladder.model.LadderTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RetrieveResultRequestTest {
    public static final RetrieveResultRequest RETRIEVE_RESULT_REQUEST = RetrieveResultRequest.of(LadderTest.LADDER, UserLadderResultsTest.USERS_LADDER_RESULTS);

    @Test
    void ofTest() {
        // then
        assertThat(RETRIEVE_RESULT_REQUEST).isNotNull();
    }

    @Test
    void checkExceptionForInvalidLadderTest() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> RetrieveResultRequest.of(null, UserLadderResultsTest.USERS_LADDER_RESULTS)
        );
    }

    @Test
    void checkExceptionForInvalidUserResultRequestTest() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> RetrieveResultRequest.of(LadderTest.LADDER, null)
        );
    }

    @Test
    void ladderGameTest() {
        // when & then
        assertThat(RETRIEVE_RESULT_REQUEST.ladderGame()).isNotNull();
    }
}
