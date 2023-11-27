package nextstep.step2.domain;

import nextstep.step2.view.OutputView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void test() {
        Line line = new Line(5);
        assertThat(line.points()).hasSize(4);

        OutputView.printLine(line);
    }

}