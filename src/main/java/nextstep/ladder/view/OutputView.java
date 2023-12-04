package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;

public class OutputView {

    private static final String EXECUTION_RESULT_MESSAGE = "\n실행결과\n";
    private static final String EXECUTION_RESULT = "\n실행 결과";

    public void printLadder(List<String> namesOfParticipants, Ladder ladder, List<String> gameResults) {
        printExecutionMessage();
        int width = ladder.getWidth();
        printParticipants(namesOfParticipants, width);
        int maxHeight = ladder.getLadderLines().getLines().get(0).getMaxHeight();
        for (int currentHeight = 0; currentHeight < maxHeight; currentHeight++) {
            printLadderOfCurrentHeight(namesOfParticipants, ladder, currentHeight);
        }
        printGameResult(gameResults, width);
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

    private String createNormalParticipantFormat(String participantName, int width) {
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

    private void printGameResult(List<String> gameResults, int width) {
        String gameResultFormat = createGameResultFormat(gameResults);
        System.out.println(gameResultFormat);
    }

    private String createGameResultFormat(List<String> gameResults) {
        return gameResults.stream().map(gameResult -> {
            if (gameResult.equals("꽝")) {
                return "    꽝 ";
            }
            String tempResult = "     " + gameResult + " ";
            return tempResult.substring(tempResult.length() - 6);
        }).collect(Collectors.joining());
    }

    public void printLadderGameResult(List<Participant> participants, List<String> gameResults) {
        System.out.println(EXECUTION_RESULT);
        for (Participant participant : participants) {
            String participantName = participant.getName();
            int position = participant.getPosition().getValue();
            System.out.printf("%s : %s\n", participantName, gameResults.get(position));
        }
    }
}
