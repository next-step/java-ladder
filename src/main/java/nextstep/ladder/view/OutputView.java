package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Ladder;

public class OutputView {

    private static final String EXECUTION_RESULT_MESSAGE = "실행결과\n";

    public void printLadderExecutionResult(List<String> namesOfParticipants, Ladder ladder) {
        printExecutionMessage();
        printParticipants(namesOfParticipants, ladder.getWidth());
        int maxHeight = ladder.getLadderLines().getLines().get(0).getMaxHeight();
        for (int currentHeight = 0; currentHeight < maxHeight; currentHeight++) {
            printLadderOfCurrentHeight(namesOfParticipants, ladder, currentHeight);
        }
    }

    private void printExecutionMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    private void printParticipants(List<String> namesOfParticipants, int width) {
        for (String participantName : namesOfParticipants) {
            System.out.print(createCompartmentsBetweenParticipants(participantName, width));
        }
        System.out.println();
    }

    private String createCompartmentsBetweenParticipants(String participantName, int width) {
        if (isSameAsWidth(participantName, width)) {
            return createMaxSizeParticipantFormat(participantName);
        }
        return createNormalParticipantFormat(participantName, width);
    }

    private boolean isSameAsWidth(String participantName, int width) {
        return participantName.length() == width;
    }

    private String createMaxSizeParticipantFormat(String participantName) {
        return " " + participantName;
    }

    private static String createNormalParticipantFormat(String participantName, int width) {
        String tempName = " ".repeat(width) + participantName + " ";
        return tempName.substring(tempName.length() - (width + 1));
    }

    private void printLadderOfCurrentHeight(List<String> namesOfParticipants, Ladder ladder, int currentHeight) {
        printCompartmentsOfCurrentHeight(ladder.getWidth());
        printPureLadderOfCurrentHeight(namesOfParticipants, ladder, currentHeight);
    }

    private void printCompartmentsOfCurrentHeight(int width) {
        System.out.print(" ".repeat(width));
    }

    private void printPureLadderOfCurrentHeight(List<String> namesOfParticipants, Ladder ladder,
                                                int currentHeight) {
        int bound = namesOfParticipants.size() - 1;
        for (int currentPointIndex = 0; currentPointIndex < bound; currentPointIndex++) {
            printOnePieceOfLine();
            printHorizontalLine(ladder, currentHeight, currentPointIndex);
        }
        printLastPieceOfLine();
    }

    private void printOnePieceOfLine() {
        System.out.print("|");
    }

    private void printHorizontalLine(Ladder ladder, int presentHeight, int currentPointIndex) {
        if (hasHorizontalLine(ladder, presentHeight, currentPointIndex)) {
            System.out.print("-".repeat(ladder.getWidth()));
            return;
        }
        System.out.print(" ".repeat(ladder.getWidth()));
    }

    private boolean hasHorizontalLine(Ladder ladder, int presentHeight, int currentPointIndex) {
        return ladder.getLadderLines().getLines().get(currentPointIndex).horizontalLine(presentHeight).pointStatus();
    }

    private void printLastPieceOfLine() {
        printOnePieceOfLine();
        System.out.println();
    }
}
