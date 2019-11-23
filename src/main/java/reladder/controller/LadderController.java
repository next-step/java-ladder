package reladder.controller;

import reladder.domain.*;
import reladder.service.LadderGame;
import reladder.view.ResultView;

import java.util.Map;

public class LadderController {

    public LadderGame execute(String names, int height, String result) {

        MatchUp matchUp = new MatchUp(names, result);
        Ladder ladder = new DefaultLadderGenerator().generate(height, matchUp.getPeopleCount());
        LadderGame ladderGame = new LadderGame(ladder, matchUp);
        ResultView.printLadderGame(ladderGame);
        return ladderGame;
    }

    public void result(LadderGame ladderGame, String personName) {
        String result = ladderGame.getResult(personName);
        ResultView.printResultOnce(result);
    }

    public void allResult(LadderGame ladderGame) {
        Map<String, Object> result = ladderGame.getResultAll();
        ResultView.printResult(result);
    }
}
