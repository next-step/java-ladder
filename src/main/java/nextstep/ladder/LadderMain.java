package nextstep.ladder;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.lines.DefaultRandomService;
import nextstep.ladder.domain.lines.RandomLinesFactory;
import nextstep.ladder.domain.lines.strategy.line.RandomLineCreationStrategy;
import nextstep.ladder.domain.lines.strategy.point.RandomPointCreationStrategy;
import nextstep.ladder.domain.lines.strategy.point.RandomPointsFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();

        List<String> participantsNames = inputView.names();
        List<String> gameResults = inputView.gameResults();
        int height = inputView.height();

        LadderController ladderController = new LadderController(
                new RandomLinesFactory(
                        new RandomLineCreationStrategy(
                                new RandomPointsFactory(
                                        new RandomPointCreationStrategy(
                                                new DefaultRandomService(
                                                        new Random()))))));

        Ladder ladder = ladderController.getLadder(participantsNames, height);
        outputView.printLadder(participantsNames, ladder, gameResults);

        String target = inputView.targetName();
        List<Participant> participants = ladderController.startGame(ladder, participantsNames, target);
        outputView.printLadderGameResult(participants, gameResults);
    }
}
