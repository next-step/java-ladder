package reladder.controller;

import reladder.domain.*;
import reladder.service.LadderGame;
import reladder.service.LadderGameResult;
import reladder.view.ResultView;

import java.util.Map;

public class LadderController {

    public LadderGame execute(String names, int height, String result) {
        MatchUp matchUp = new MatchUp(names, result);
        Ladder ladder = DefaultLadderGenerator.getInstance().generate(height, matchUp.getPeopleCount());
        LadderGame ladderGame = new LadderGame(ladder, matchUp);
        ResultView.printLadderGame(ladderGame);
        return ladderGame;
    }

    public void result(LadderGame ladderGame, String personName) {
        LadderGameResult ladderGameResult = new LadderGameResult(ladderGame);
        String result = ladderGameResult.getResult(personName);
        ResultView.printResultOnce(result);
    }

    public void allResult(LadderGame ladderGame) {
        LadderGameResult ladderGameResult = new LadderGameResult(ladderGame);
        Map<String, Object> result = ladderGameResult.getResultAll();
        ResultView.printResult(result);
    }
}
