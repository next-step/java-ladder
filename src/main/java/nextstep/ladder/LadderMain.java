package nextstep.ladder;

import java.util.List;
import java.util.Scanner;
import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.lines.RandomLinesFactory;
import nextstep.ladder.domain.lines.strategy.RandomFirstLineCreationStrategy;
import nextstep.ladder.domain.lines.strategy.RandomLeftLineCreationStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();

        List<String> names = inputView.names();
        int height = inputView.height();

        LadderController ladderController = new LadderController(
                new RandomLinesFactory(
                        new RandomFirstLineCreationStrategy(),
                        new RandomLeftLineCreationStrategy()
                ));
        Ladder ladder = ladderController.startLadderGame(names, height);
        outputView.printLadderExecutionResult(names, ladder);
    }
}
