package nextstep.step2.domain;

import nextstep.step2.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void test() {
        Ladder ladder = new Ladder(5, 6);
        Assertions.assertThat(ladder.lines().size()).isEqualTo(5);

        OutputView.printLadder(ladder);
    }

}