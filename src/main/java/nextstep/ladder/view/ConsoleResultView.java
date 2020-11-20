package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.util.LadderRenderer;

import java.util.function.Consumer;

public class ConsoleResultView implements ResultView {
    public static final String HEADER_MSG = "실행 결과";
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

    private void appendHeader(StringBuilder resultBuilder) {
        resultBuilder.append(HEADER_MSG).append(System.lineSeparator());
    }

    private void appendParticipantNames(Participants participants, StringBuilder resultBuilder) {
        participants.namesValueForEach(appendName(resultBuilder));
        resultBuilder.append(System.lineSeparator());
    }

    private Consumer<String> appendName(StringBuilder namesBuilder) {
        return (String name) -> namesBuilder.append(String.format("%6s", name));
    }

    private void appendLadder(Ladder ladder, StringBuilder resultBuilder) {
        LadderRenderer ladderRenderer = LadderRenderer.builder()
                .firstPartOfLine(() -> resultBuilder.append(EMPTY_POINT).append(LADDER_STICK))
                .point(point -> resultBuilder.append(point ? EXIST_POINT : EMPTY_POINT))
                .ladderStick(() -> resultBuilder.append(LADDER_STICK))
                .lastPartOfLine(() -> resultBuilder.append(System.lineSeparator()))
                .build();

        ladder.linesForEach(ladderRenderer);
    }
}
