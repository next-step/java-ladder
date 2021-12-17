package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.LadderResults;
import nextstep.ladder.model.Participants;
import nextstep.ladder.model.value.Height;
import nextstep.ladder.model.value.Participant;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputVIew;

public class LadderGame {

    public void start() {
        Participants participants = InputView.inputJoinParticipants();
        LadderResults ladderResults = InputView.inputLadderResults();
        Height ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = Ladder.of(ladderHeight.getHeight(), participants.size());
        printResult(participants, ladder, ladderResults);
    }

    private void printResult(Participants participants, Ladder ladder, LadderResults ladderResults) {

        OutputVIew outputVIew = new OutputVIew();
        outputVIew.printResult(participants, ladder, ladderResults);
        Participants resultParticipants = participants.execute(ladder);

        String findName;
        while(true) {
            findName = InputView.wantShowPerson();

            if(allOrName(findName)) {
                break;
            }

            Participant participant = resultParticipants.findByName(findName);
            outputVIew.printResult(participant, ladderResults);
        }
        outputVIew.printAllResult(resultParticipants, ladderResults);
    }

    private boolean allOrName(String findName) {
        return "all".equals(findName);
    }

}
