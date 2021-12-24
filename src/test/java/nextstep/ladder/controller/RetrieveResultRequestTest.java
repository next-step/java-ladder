package nextstep.ladder.controller;

import nextstep.ladder.model.LadderTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RetrieveResultRequestTest {
    public static final RetrieveResultRequest RETRIEVE_RESULT_REQUEST = RetrieveResultRequest.of(LadderTest.LADDER, UserResultsRequestTest.USER_RESULTS_REQUEST);

    @Test
    void ofTest() {
        // then
        assertThat(RETRIEVE_RESULT_REQUEST).isNotNull();
    }

    @Test
    void checkExceptionForInvalidLadderTest() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> RetrieveResultRequest.of(null, UserResultsRequestTest.USER_RESULTS_REQUEST)
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
    void getLadderTest() {
        // when & then
        assertThat(RETRIEVE_RESULT_REQUEST.getLadder()).isEqualTo(LadderTest.LADDER);
    }
}
