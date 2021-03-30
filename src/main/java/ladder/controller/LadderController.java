package ladder.controller;

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
    }

    private ParticipantList participantList(){
        String participants = inputView.getParticipants();
        return new ParticipantList(participants);
    }

    private ResultCaseList resultCaseList(ParticipantList participantList){
        String results = inputView.getResults();
        return new ResultCaseList(participantList, results);
    }
}
