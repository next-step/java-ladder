package ladder.controller;

import ladder.domain.game.Game;
import ladder.domain.Height;
import ladder.domain.game.GameResult;
import ladder.domain.participant.ParticipantList;
import ladder.domain.ladderMap.LadderMap;
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
        inputView.getNameQuery();
    }

    private ParticipantList participantList(){
        String participants = inputView.getParticipants();
        return new ParticipantList(participants);
    }

    private ResultList resultList(ParticipantList participantList){
        String results = inputView.getResults();
        return new ResultList(results, participantList);
    }

    private Height height(){
        int maximumLadderHeight = inputView.getMaximumLadderHeight();
        return new Height(maximumLadderHeight);
    }

}
