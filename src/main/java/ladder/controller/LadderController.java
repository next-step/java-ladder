package ladder.controller;

import ladder.domain.game.Game;
import ladder.domain.game.GameResult;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.LadderMap;
import ladder.domain.participant.ParticipantList;
import ladder.domain.result.ResultList;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    public void generateLadder() {
        ParticipantList verifiedParticipants = participantList();
        ResultList resultList = resultList(verifiedParticipants);
        Height verifiedHeight = height();

        LadderMap ladderMap = new LadderMap(verifiedParticipants, verifiedHeight);
        Game game = new Game(ladderMap, resultList);
        resultView.printGameMap(game);

        GameResult gameResult = game.run();
        getAndPrintNameQueries(gameResult);
    }

    private ParticipantList participantList() {
        String participants = inputView.getParticipants();
        return new ParticipantList(participants);
    }

    private ResultList resultList(ParticipantList participantList) {
        String results = inputView.getResults();
        return new ResultList(results, participantList);
    }

    private Height height() {
        int maximumLadderHeight = inputView.getMaximumLadderHeight();
        return new Height(maximumLadderHeight);
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

}
