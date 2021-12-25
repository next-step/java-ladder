package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.UserResults;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderControllerTest {
    private static final LadderController LADDER_CONTROLLER = new LadderController();

    @Test
    void createTest() {
        // when & then
        assertThat(LADDER_CONTROLLER).isNotNull();
    }

    @Test
    void createLadderTest() {
        // when
        Ladder ladder = LADDER_CONTROLLER.createLadder(CreateLadderRequestTest.CREATE_LADDER_REQUEST);
        // then
        assertThat(ladder).isNotNull();
    }

    @Test
    void retrieveUserResultsTest() {
        // when
        UserResults userResults = LADDER_CONTROLLER.retrieveUserResults(RetrieveResultRequestTest.RETRIEVE_RESULT_REQUEST);
        // then
        assertThat(userResults).isNotNull();
    }
}
