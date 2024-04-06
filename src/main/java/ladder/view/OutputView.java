package ladder.view;

import ladder.model.*;

import java.util.List;

public class OutputView {
    private static final int NAME_SPACING = 6;
    private static final String NAME_DELIMITER = " : ";

    private static final LadderDrawing ladderDrawing = new LadderDrawing();

    public void showLadder(Participants participants, Ladder ladder, Prizes prizes) {
        System.out.println("사다리 결과\n");
        printAllParticipants(participants);
        ladderDrawing.printLadder(ladder);
        printAllPrizes(prizes);
    }

    private void printAllParticipants(Participants participants) {
        participants.getParticipants()
                .forEach(participant -> System.out.printf("%-" + NAME_SPACING + "s", participant.getParticipant()));
        System.out.println();
    }

    private void printAllPrizes(Prizes prizes) {
        prizes.getPrizes()
                .forEach(prize -> System.out.printf("%-" + NAME_SPACING + "s", prize.getPrizeName()));
        System.out.println("\n");
    }

    public void showLadderGameResult(List<Participant> targetParticipants, LadderGameResult result) {
        System.out.println("\n실행 결과");
        targetParticipants.forEach(participant -> {
            System.out.printf("%s%s%s%n", participant.getParticipant(), NAME_DELIMITER, result.getPrizeOf(participant));
        });
    }
}
