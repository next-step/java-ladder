package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderControllerTest {

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
        Ladder ladder = controller.run();
        // then
        assertThat(ladder).isNotNull();
    }
}
