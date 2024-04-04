package ladder.view;

import ladder.model.Ladder;
import ladder.model.Participants;

public class OutputView {
    private static final int NAME_SPACING = 6;

    private static final LadderDrawing ladderDrawing = new LadderDrawing();

    public void showResult(Participants participants, Ladder ladder) {
        System.out.println("실행 결과\n");
        printAllParticipants(participants);
        ladderDrawing.printLadder(ladder);
    }

    private void printAllParticipants(Participants participants) {
        participants.getParticipants()
                .forEach(participant -> System.out.printf("%-" + NAME_SPACING + "s", participant.getParticipant()));
        System.out.println();
    }
}
