package ladder.controller;

import ladder.entity.game.Game;
import ladder.entity.game.GameResult;
import ladder.entity.ladderMap.LadderHeight;
import ladder.entity.ladderMap.LadderMap;
import ladder.entity.participant.ParticipantList;
import ladder.entity.resultCase.ResultCaseList;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    public void run(){
        ParticipantList participantList = participantList();
        ResultCaseList resultCaseList = resultCaseList(participantList);
        LadderHeight ladderHeight = ladderHeight();

        LadderMap ladderMap = new LadderMap(participantList, ladderHeight);
        Game game = new Game(ladderMap, resultCaseList);
        resultView.printGameMap(game);

        GameResult gameResult = game.run();
        getAndPrintNameQueries(gameResult);
    }

    private void getAndPrintNameQueries(GameResult gameResult) {
        boolean stopFlag = false;
        while (!stopFlag) {
            String queryName = inputView.getNameQuery();
            stopFlag = printAndShouldStop(gameResult, queryName);
        }
    }

    private boolean printAndShouldStop(GameResult gameResult, String queryName) {
        if (GameResult.shouldStop(queryName)) {
            resultView.printAllResults(gameResult);
            return true;
        }
        resultView.printResult(gameResult.result(queryName));
        return false;
    }

    private ParticipantList participantList(){
        String participants = inputView.getParticipants();
        return new ParticipantList(participants);
    }

    private ResultCaseList resultCaseList(ParticipantList participantList){
        String results = inputView.getResults();
        return new ResultCaseList(participantList, results);
    }

    private LadderHeight ladderHeight(){
        int maximumLadderHeight = inputView.getMaximumLadderHeight();
        return new LadderHeight(maximumLadderHeight);
    }
}
