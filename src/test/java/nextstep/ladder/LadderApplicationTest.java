package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.view.ConsoleResultView;
import nextstep.ladder.view.MockInputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.formatter.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LadderApplicationTest {

    private MockInputView mockInputView;
    private LadderApplication ladderApplication;

    @BeforeEach
    void setUp() {
        final Formatter<Direction> directionFormatter = new DirectionFormatter();
        final Formatter<Point> pointFormatter = new PointFormatter(directionFormatter);
        final Formatter<Line> lineFormatter = new LineFormatter(pointFormatter);
        final Formatter<Ladder> ladderFormatter = new LadderFormatter(lineFormatter);

        mockInputView = new MockInputView();
        final ResultView consoleResultView = new ConsoleResultView(ladderFormatter);
        ladderApplication = new LadderApplication(mockInputView, consoleResultView);
    }

    @Test
    @DisplayName("예제가 잘 동작하는지")
    void test() {
        // given
        mockInputView.setNames(Arrays.asList("pobi", "honux", "crong", "jk"));
        mockInputView.setHeight(5);
        // when then
        ladderApplication.run();
    }
}