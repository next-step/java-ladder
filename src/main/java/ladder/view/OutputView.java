package ladder.view;

import ladder.controller.dto.LadderGenerationResponse;

import java.util.List;

public class OutputView {

    public void printLadderGenerationResult(LadderGenerationResponse response) {
        System.out.println("\n실행결과\n");
        printParticipants(response.getParticipants(), response.getLadderWidth());
    }

    private void printParticipants(List<String> participants, int ladderWidth) {
        for (String participant : participants) {
            System.out.print(printParticipant(participant, ladderWidth));
        }
    }

    private String printParticipant(String participant, int ladderWidth) {
        StringBuilder result = new StringBuilder(participant);
        for (int i = 0; i < ladderWidth - participant.length() + 1; i++) {
            result.insert(0, " ");
        }
        return result.toString();
    }
}
