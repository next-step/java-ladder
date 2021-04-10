package ladder.view;

import ladder.controller.dto.LadderGenerationResponse;
import ladder.controller.dto.LadderLine;

import java.util.List;

public class OutputView {

    private static final String EMPTY_HORIZON = " ";
    private static final String HORIZON = "-";
    private static final String POINT = "|";

    public void printLadderGenerationResult(LadderGenerationResponse response) {
        System.out.println("\n실행결과");
        printParticipants(response.getParticipantNameList(), response.getLadderWidth());
        System.out.println();
        printLadder(response.getLadderLineList(), response.getLadderWidth());
    }

    private void printParticipants(List<String> participants, int ladderWidth) {
        for (String participant : participants) {
            System.out.print(printParticipant(participant, ladderWidth));
        }
    }

    private String printParticipant(String participant, int ladderWidth) {
        StringBuilder result = new StringBuilder(participant);
        for (int i = 0; i < ladderWidth - participant.length() + 1; i++) {
            result.insert(0, EMPTY_HORIZON);
        }
        return result.toString();
    }

    private void printLadder(List<LadderLine> ladderLineList, int ladderWidth) {
        for (LadderLine ladderLine : ladderLineList) {
            System.out.println(writeHorizon(EMPTY_HORIZON, ladderWidth) + writeLine(ladderLine, ladderWidth));
        }
    }

    private String writeLine(LadderLine ladderLine, int ladderWidth) {
        StringBuilder line = new StringBuilder();
        for (Boolean point : ladderLine.getPointList()) {
            line.append(POINT).append(writeHorizon(convertToHorizon(point), ladderWidth));
        }
        return line.toString();
    }

    private String convertToHorizon(Boolean point) {
        if (point) {
            return HORIZON;
        }
        return EMPTY_HORIZON;
    }

    private String writeHorizon(String horizon, int ladderWidth) {
        StringBuilder horizons = new StringBuilder();
        for (int i = 0; i < ladderWidth; i++) {
            horizons.append(horizon);
        }
        return horizons.toString();
    }
}
