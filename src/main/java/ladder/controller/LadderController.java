package ladder.controller;

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
        resultView.printGameMap(ladderMap);
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
