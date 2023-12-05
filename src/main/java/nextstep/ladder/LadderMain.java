package nextstep.ladder;

import java.util.List;
import nextstep.ladder.config.ObjectFactory;
import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        ObjectFactory objectFactory = new ObjectFactory();
        InputView inputView = objectFactory.inputView();
        LadderController ladderController = objectFactory.controller();
        OutputView outputView = objectFactory.outputView();

        List<String> participantsNames = inputView.names();
        List<String> gameResults = inputView.gameResults();

        Ladder ladder = getLadder(inputView, ladderController, participantsNames);
        outputView.printLadder(participantsNames, ladder, gameResults);

        List<Participant> participants = getFinalPositions(inputView, ladderController, ladder, participantsNames);
        outputView.printLadderGameResult(participants, gameResults);
    }

    private static Ladder getLadder(InputView inputView, LadderController ladderController,
                                    List<String> participantsNames) {
        int height = inputView.height();
        return ladderController.getLadder(participantsNames, height);
    }

    private static List<Participant> getFinalPositions(InputView inputView, LadderController ladderController,
                                                       Ladder ladder, List<String> participantsNames) {
        String target = inputView.targetName();
        return ladderController.startGame(ladder, participantsNames, target);
    }
}
