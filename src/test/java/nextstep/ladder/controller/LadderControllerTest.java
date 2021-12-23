package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderControllerTest {

    private static final RunRequest VALID_REQUEST = RunRequest.of(4, 5);

    @Test
    void createTest() {
        // when & then
        assertThat(new LadderController()).isNotNull();
    }

    @Test
    void runTest() {
        // given
        LadderController controller = new LadderController();
        // when
        Ladder ladder = controller.createLadder(VALID_REQUEST);
        // then
        assertThat(ladder).isNotNull();
    }
}
