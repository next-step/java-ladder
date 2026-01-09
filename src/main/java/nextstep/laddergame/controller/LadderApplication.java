package nextstep.laddergame.controller;

import java.util.List;
import nextstep.laddergame.domain.LadderGame;
import nextstep.laddergame.domain.LadderResult;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        String participantsName = InputView.inputParticipantsName();
        String goals = InputView.inputGoal();
        String ladderHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(participantsName, ladderHeight, goals);
        OutputView.printLadderResult(ladderGame);

        List<LadderResult> ladderResults = ladderGame.ladderGameResult();
        while (true) {
            String target = InputView.inputResultTarget();
            OutputView.printResult(ladderResults, target);
            if ("all".equals(target)) {
                break;
            }
        }
    }
}