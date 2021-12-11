package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.PositiveNumber;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class GameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Participants participants = inputView.inputJoinParticipants();

        LadderResults ladderResults = inputView.inputResults();

        PositiveNumber ladderHeight = inputView.inputLadderHeight();
        Ladder ladder = Ladder.create(ladderHeight, participants.size());

        Participants resultParticipants = participants.execute(ladder);

        OutputView outputView = new OutputView();
        outputView.printLadder(resultParticipants, ladder, ladderResults);

        String findName;
        while (true) {
            findName = inputView.inputShowParticipantName();

            if (isStopInput(findName)) {
                break;
            }

            Participant participant = resultParticipants.findByName(findName);
            outputView.printResult(participant, ladderResults);
        }

        outputView.printAllResult(resultParticipants, ladderResults);
    }

    private static boolean isStopInput(String findName) {
        if (findName.equals("all")) {
            return true;
        }
        return false;
    }
}
