package nextstep.ladder.view;

import nextstep.ladder.domain.ExecutionsResults;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;

import java.util.function.Consumer;

public class ConsoleResultView implements ResultView {
    private static final String HEADER_MSG = "실행 결과";
    private static final String LADDER_STICK = "|";
    private static final String EXIST_POINT = "-----";
    private static final String EMPTY_POINT = "     ";
    private static final String NAME_STRING_FORMAT = "%6s";

    @Override
    public void printResult(Participants participants, Ladder ladder, ExecutionsResults executionsResults) {
        StringBuilder resultBuilder = new StringBuilder();

        appendHeader(resultBuilder);
        appendParticipantNames(participants, resultBuilder);
        appendLadder(ladder, resultBuilder);
        appendResults(executionsResults, resultBuilder);

        System.out.println(resultBuilder.toString());
    }

    private void appendHeader(StringBuilder resultBuilder) {
        resultBuilder.append(HEADER_MSG).append(System.lineSeparator());
    }

    private void appendParticipantNames(Participants participants, StringBuilder resultBuilder) {
        participants.namesValueForEach(appendName(resultBuilder));
        resultBuilder.append(System.lineSeparator());
    }

    private Consumer<String> appendName(StringBuilder resultBuilder) {
        return (String name) -> resultBuilder.append(String.format(NAME_STRING_FORMAT, name));
    }

    private void appendLadder(Ladder ladder, StringBuilder resultBuilder) {
        LineRenderer lineRenderer = LineRenderer.builder()
                .firstPartOfLine(() -> resultBuilder.append(EMPTY_POINT).append(LADDER_STICK))
                .point(point -> resultBuilder.append(point ? EXIST_POINT : EMPTY_POINT))
                .ladderStick(() -> resultBuilder.append(LADDER_STICK))
                .lastPartOfLine(() -> resultBuilder.append(System.lineSeparator()))
                .build();

        ladder.linesForEach(lineRenderer.renderLine());
    }

    private void appendResults(ExecutionsResults executionsResults, StringBuilder resultBuilder) {
        executionsResults.forEach(appendName(resultBuilder));
    }
}
