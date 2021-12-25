package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.UserResults;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderControllerTest {

    @Test
    void createLadderTest() {
        // when
        Ladder ladder = LadderController.createLadder(CreateLadderRequestTest.CREATE_LADDER_REQUEST);
        // then
        assertThat(ladder).isNotNull();
    }

    @Test
    void retrieveUserResultsTest() {
        // when
        UserResults userResults = LadderController.retrieveUserResults(RetrieveResultRequestTest.RETRIEVE_RESULT_REQUEST);
        // then
        assertThat(userResults).isNotNull();
    }
}
