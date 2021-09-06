package nextstep.ladder.view.output;

import nextstep.ladder.Ladder;
import nextstep.ladder.line.HorizontalLine;
import nextstep.ladder.participant.Participant;
import nextstep.ladder.participant.Participants;
import nextstep.ladder.point.Point;
import nextstep.ladder.result.ExecutionResult;
import nextstep.ladder.view.OutPutViewUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private static final String POINT = "|";
    private static final String CONNECTED = "-----";
    private static final String NOT_CONNECTED = "     ";
    private static final String HORIZONTAL_LINE_PADDING = "     ";

    public void printTargetResult(String target, Participants participants, List<String> executionResult, ExecutionResult result) {
        if ("all".equals(target)) {
            printAllParticipantsResult(participants, executionResult, result);
            return;
        }

        int indexByName = participants.findIndexByName(target);
        String targetResult = executionResult.get(result.get(indexByName));
        printExecutionResult(targetResult);
    }

    private void printExecutionResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    private void printAllParticipantsResult(Participants participants, List<String> executionResult, ExecutionResult result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < participants.size(); i++) {
            Participant participant = participants.get(i);
            String name = participant.getName();
            String targetExecutionResult = executionResult.get(result.get(i));
            stringBuilder.append(name + " : " + targetExecutionResult);
            stringBuilder.append(LINE_SEPARATOR);
        }

        printExecutionResult(stringBuilder.toString());
    }

    public void printLadder(Participants participants, Ladder ladder, List<String> executionResults) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("사다리 결과");
        stringBuilder.append(LINE_SEPARATOR);

        String participantsName = participants.getParticipantsName();

        stringBuilder.append(participantsName);
        stringBuilder.append(LINE_SEPARATOR);

        List<HorizontalLine> horizontalLines = ladder.getHorizontalLines();

        for (HorizontalLine horizontalLine : horizontalLines) {
            printHorizontalLine(horizontalLine, stringBuilder);
            stringBuilder.append(LINE_SEPARATOR);
        }

        String executionResult = executionResults.stream()
                .map(OutPutViewUtils::appendPaddingBeforeValue)
                .collect(Collectors.joining());

        stringBuilder.append(executionResult);

        System.out.println(stringBuilder.toString());
    }

    private void printHorizontalLine(HorizontalLine horizontalLine, StringBuilder stringBuilder) {
        List<Point> points = horizontalLine.getPoints();
        stringBuilder.append(HORIZONTAL_LINE_PADDING);
        for (int i = 1; i < points.size(); i++) {
            Point prevPoint = points.get(i - 1);
            Point currentPoint = points.get(i);
            printPoint(prevPoint, currentPoint, stringBuilder);
        }
        stringBuilder.append(POINT);
    }

    private void printPoint(Point prevPoint, Point currentPoint, StringBuilder stringBuilder) {
        stringBuilder.append(POINT);
        if (prevPoint.isMovableRight() && currentPoint.isMovableLeft()) {
            stringBuilder.append(CONNECTED);
            return;
        }
        stringBuilder.append(NOT_CONNECTED);
    }
}
