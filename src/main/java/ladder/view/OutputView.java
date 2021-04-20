package ladder.view;

import ladder.service.dto.LadderGameResult;
import ladder.controller.dto.LadderGameResponse;
import ladder.controller.dto.LadderLine;

import java.util.List;

public class OutputView {

    private static final String EMPTY_HORIZON = " ";
    private static final String HORIZON = "-";
    private static final String POINT = "|";

    public void printLadderGenerationResult(LadderGameResponse response) {
        System.out.println(System.lineSeparator() + "사다리 결과");
        printParticipants(response.getLadderGameResults(), response.getLadderWidth());
        System.out.println();
        printLadder(response.getLadderLines(), response.getLadderWidth());
        printMatchingItems(response.getLadderGameResults(), response.getLadderWidth());
        System.out.println();
    }

    private void printParticipants(List<LadderGameResult> ladderGameResults, int ladderWidth) {
        for (LadderGameResult gameResult : ladderGameResults) {
            System.out.print(printHeaderAndFooterElement(gameResult.getParticipantName(), ladderWidth));
        }
    }

    private void printMatchingItems(List<LadderGameResult> ladderGameResults, int ladderWidth) {
        for (LadderGameResult gameResult : ladderGameResults) {
            System.out.print(printHeaderAndFooterElement(gameResult.getMatchingItem(), ladderWidth));
        }
    }

    private String printHeaderAndFooterElement(String element, int ladderWidth) {
        StringBuilder result = new StringBuilder(element);
        for (int i = 0; i < ladderWidth - element.length() + 1; i++) {
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

    public void printGameResult(List<LadderGameResult> gameResponses, String inputInquiryTargetName) {
        for (LadderGameResult gameResponse : gameResponses) {
            if(inputInquiryTargetName.equals(gameResponse.getParticipantName())) {
                System.out.println(System.lineSeparator() + "실행 결과");
                System.out.println(gameResponse.getMatchingItem());
                return;
            }
        }
        System.out.println("존재하지 않는 참가자입니다.");
    }

    public void printGameResults(List<LadderGameResult> gameResponses) {
        System.out.println(System.lineSeparator() + "실행 결과");
        for (LadderGameResult gameResponse : gameResponses) {
            System.out.println(gameResponse.getParticipantName() + " : " + gameResponse.getMatchingItem());
        }
    }
}
