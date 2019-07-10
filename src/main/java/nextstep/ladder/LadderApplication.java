package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.ConsoleInputView;
import nextstep.ladder.view.ConsoleResultView;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.formatter.*;

import java.util.List;

public class LadderApplication {

    private final InputView inputView;
    private final ResultView resultView;

    public LadderApplication(final InputView inputView, final ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public static void main(final String[] args) {
        final Formatter<Direction> directionFormatter = new DirectionFormatter();
        final Formatter<Point> pointFormatter = new PointFormatter(directionFormatter);
        final Formatter<Line> lineFormatter = new LineFormatter(pointFormatter);
        final Formatter<Ladder> ladderFormatter = new LadderFormatter(lineFormatter);

        final InputView consoleInputView = new ConsoleInputView();
        final ResultView consoleResultView = new ConsoleResultView(ladderFormatter);
        final LadderApplication ladderApplication = new LadderApplication(consoleInputView, consoleResultView);
        ladderApplication.run();
    }

    public void run() {
        final List<String> names = inputView.inputNames();
        final int height = inputView.inputHeight();

        final Ladder ladder = LadderFactory.create(names, height);

        resultView.print(names, ladder);
    }
}
