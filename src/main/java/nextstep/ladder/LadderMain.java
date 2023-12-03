package nextstep.ladder;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.lines.DefaultRandomService;
import nextstep.ladder.domain.lines.RandomLinesFactory;
import nextstep.ladder.domain.lines.strategy.point.RandomPointCreationStrategy;
import nextstep.ladder.domain.lines.strategy.line.RandomLineCreationStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();

        List<String> names = inputView.names();
        int height = inputView.height();

        LadderController ladderController = new LadderController(
                new RandomLinesFactory(new RandomLineCreationStrategy(
                        new RandomPointCreationStrategy(new DefaultRandomService(new Random())))));
        Ladder ladder = ladderController.startLadderGame(names, height);
        outputView.printLadderExecutionResult(names, ladder);
    }
}
