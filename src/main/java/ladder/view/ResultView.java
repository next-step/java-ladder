package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LADDER_RESULT = "사다리 결과";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String EXECUTION_MENT = "%s : %s";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-";
    private static final String SPACE = " ";
    private static final String REQUEST_ALL = "all";

    public void showLadderResult(LadderGame ladderGame) {
        System.out.println(LADDER_RESULT);
        showParticipants(ladderGame.getParticipantNamesAsEntity());
        showLadder(ladderGame);
        showExecutionResults(ladderGame.getExecutionResults());
    }

    private void showExecutionResults(ExecutionResults executionResults) {
        System.out.println(printExecutionResults(executionResults.getExecutionResultsAsList()));
    }

    private String printExecutionResults(List<ExecutionResult> executionResultsList) {
        return executionResultsList.stream()
                .map(ExecutionResult::getExecutionResult)
                .collect(Collectors.joining(SPACE.repeat(executionResultsList.size())));
    }

    private void showLadder(LadderGame ladderGame) {
        List<Line> lines = ladderGame.getLadder().getLines();
        int participantsSize = ladderGame.getParticipantNamesAsEntity().getParticipantsSize();

        for (Line line : lines) {
            line.getPoints().forEach(point -> drawHorizontalLine(participantsSize, point));
            System.out.print(VERTICAL_LINE);
            System.out.println();
        }
    }

    private void drawHorizontalLine(int participantsSize, Boolean point) {
        System.out.print(VERTICAL_LINE);
        System.out.print(point ? HORIZONTAL_LINE.repeat(participantsSize) : SPACE.repeat(participantsSize));
    }

    private void showParticipants(ParticipantNames participantNames) {
        List<ParticipantName> names = participantNames.getParticipantNamesAsList();
        System.out.println(printNames(names));
    }

    private String printNames(List<ParticipantName> names) {
        return names.stream().map(ParticipantName::getParticipantNameAsString)
                .collect(Collectors.joining(SPACE.repeat(names.size())));
    }

    public void showExecutionResult(LadderGame ladderGame) {
        String candidate = InputView.requestWhoDoYouWant();

        System.out.println(EXECUTION_RESULT);

        if (candidate.equals(REQUEST_ALL)) {
            printAllExecutionResult(ladderGame);
            return;
        }
        System.out.println(ladderGame.findEachResult(new ParticipantName(candidate)));

        showExecutionResult(ladderGame);
    }

    private void printAllExecutionResult(LadderGame ladderGame) {
        List<ParticipantName> participantNames = ladderGame.getParticipantNamesAsEntity().getParticipantNamesAsList();
        for (ParticipantName participantName : participantNames) {
            System.out.printf(EXECUTION_MENT, participantName.getParticipantNameAsString(), ladderGame.findEachResult(participantName).getExecutionResult());
            System.out.println();
        }
    }
}
