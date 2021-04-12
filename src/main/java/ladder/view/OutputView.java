package ladder.view;

import ladder.controller.dto.LadderGameResponse;
import ladder.controller.dto.LadderGameTotalResultResponse;
import ladder.controller.dto.LadderGenerationResponse;
import ladder.controller.dto.LadderLine;

import java.util.List;

public class OutputView {

    private static final String EMPTY_HORIZON = " ";
    private static final String HORIZON = "-";
    private static final String POINT = "|";

    public void printLadderGenerationResult(LadderGenerationResponse response) {
        System.out.println(System.lineSeparator() + "사다리 결과");
        printHeaderAndFooter(response.getParticipantNames(), response.getLadderWidth());
        System.out.println();
        printLadder(response.getLadderLines(), response.getLadderWidth());
        printHeaderAndFooter(response.getGameResults(), response.getLadderWidth());
        System.out.println();
    }

    private void printHeaderAndFooter(List<String> participants, int ladderWidth) {
        for (String participant : participants) {
            System.out.print(printHeaderAndFooterElement(participant, ladderWidth));
        }
    }

    private String printHeaderAndFooterElement(String participant, int ladderWidth) {
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
        for (Boolean point : ladderLine.getPoints()) {
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

    public void printGameResult(LadderGameResponse response) {
        System.out.println(System.lineSeparator() + "실행 결과");
        System.out.println(response.getGameResult());
    }

    public void printGameResults(LadderGameTotalResultResponse response) {
        System.out.println(System.lineSeparator() + "실행 결과");
        List<String> participantNames = response.getParticipantNames();
        List<String> gameResults = response.getGameResults();
        for (int i = 0; i < participantNames.size(); i++) {
            System.out.println(participantNames.get(i) + " : " + gameResults.get(i));
        }
    }
}
