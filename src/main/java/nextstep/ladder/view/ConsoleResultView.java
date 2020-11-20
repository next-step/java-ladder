package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;

import java.util.function.Consumer;

public class ConsoleResultView implements ResultView {
    private static final String LADDER_STICK = "|";
    private static final String EXIST_POINT = "-----";
    private static final String EMPTY_POINT = "     ";

    @Override
    public void printResult(Participants participants, Ladder ladder) {
        StringBuilder resultBuilder = new StringBuilder();

        appendHeader(resultBuilder);
        appendParticipantNames(participants, resultBuilder);
        appendLadder(ladder, resultBuilder);

        System.out.println(resultBuilder.toString());
    }

    private void appendLadder(Ladder ladder, StringBuilder resultBuilder) {
        ladder.linesForEach(renderFirstPartOfLine(resultBuilder), renderPoint(resultBuilder), renderLadderStick(resultBuilder), renderLastPartOfLine(resultBuilder));
    }

    private void appendParticipantNames(Participants participants, StringBuilder resultBuilder) {
        participants.namesValueForEach(renderName(resultBuilder));
        resultBuilder.append(System.lineSeparator());
    }

    private void appendHeader(StringBuilder resultBuilder) {
        resultBuilder.append("실행 결과").append(System.lineSeparator());
    }

    private Consumer<String> renderName(StringBuilder namesBuilder) {
        return (String name) -> namesBuilder.append(String.format("%6s", name));
    }

    private Runnable renderFirstPartOfLine(StringBuilder ladderBuilder) {
        return () -> ladderBuilder.append(EMPTY_POINT).append(LADDER_STICK);
    }

    private Consumer<Boolean> renderPoint(StringBuilder ladderBuilder) {
        return point -> ladderBuilder.append(point ? EXIST_POINT : EMPTY_POINT);
    }

    private Runnable renderLadderStick(StringBuilder ladderBuilder) {
        return () -> ladderBuilder.append(LADDER_STICK);
    }

    private Runnable renderLastPartOfLine(StringBuilder ladderBuilder) {
        return () -> ladderBuilder.append(System.lineSeparator());
    }
}
