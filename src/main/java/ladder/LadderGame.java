package ladder;

import ladder.domain.game.GameResult;
import ladder.domain.ladder.AutoLineGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderSize;
import ladder.domain.participant.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        String[] participantsNames = InputView.inputParticipants();
        int ladderHeight = InputView.inputLadderHeight();
        String[] ladderPrizeNames = InputView.inputLadderPrize();

        LadderSize ladderSize = new LadderSize(participantsNames.length, ladderHeight);
        Participants participants = new Participants(participantsNames, ladderSize);
        Ladder ladder = Ladder.create(ladderSize, AutoLineGenerator.create());

        ResultView.printLadder(participants.getParticipants(), ladder.getFloors());
        ResultView.printLadderPrize(ladderPrizeNames);

        participants.moveToDestination(ladder.getFloors());
        GameResult gameResult = new GameResult(participants, ladderPrizeNames, ladderSize);

        String nameForResult = "";
        do {
            nameForResult = InputView.inputParticipantsForResult();
            ResultView.printResult(participants, nameForResult, gameResult);
        } while (!nameForResult.equals("all"));
    }
}
