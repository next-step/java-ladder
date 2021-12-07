package nextstep.laddergame.view;

import java.util.List;
import java.util.stream.IntStream;

import nextstep.laddergame.model.Bridge;
import nextstep.laddergame.model.Goal;
import nextstep.laddergame.model.Line;
import nextstep.laddergame.model.Participant;
import nextstep.laddergame.model.Result;
import nextstep.laddergame.model.Results;

public final class ResultView {

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final int BUILDER_INITIAL_LENGTH = 0;
    private static final int INDENT_LENGTH = 5;

    private static final String VERTICAL = "|";
    private static final String LINE = "-";
    private static final String EMPTY = " ";
    private static final String DELIMITER = "  ";
    private static final String RESULT_SEPARATOR = " : ";
    private static final char NEW_LINE = '\n';

    private ResultView() {
    }

    public static void printLadder(List<Participant> participants, List<Line> ladder, List<Goal> goals) {
        stringBuilder.setLength(BUILDER_INITIAL_LENGTH);
        stringBuilder.append("사다리 결과")
                     .append(NEW_LINE);
        participants.forEach(participant -> stringBuilder.append(participant.name())
                                                         .append(DELIMITER));
        stringBuilder.append(NEW_LINE);
        ladder.forEach(line -> printLine(line));

        goals.forEach(goal -> stringBuilder.append(goal.value())
                                           .append(DELIMITER));
        System.out.println(stringBuilder);
    }

    private static void printLine(Line line) {
        stringBuilder.append(DELIMITER);
        line.getBridges()
            .forEach(bridge -> printBridge(bridge));
        stringBuilder.append(VERTICAL)
                     .append(NEW_LINE);
    }

    private static StringBuilder printBridge(Bridge bridge) {
        stringBuilder.append(VERTICAL);
        String line = bridge.exist() ? LINE : EMPTY;
        IntStream.range(0, INDENT_LENGTH)
                 .forEach(index -> stringBuilder.append(line));
        return stringBuilder;
    }

    public static void printResult(Results results, Participant participant) {
        stringBuilder.setLength(BUILDER_INITIAL_LENGTH);
        stringBuilder.append("실행 결과")
                     .append(NEW_LINE);

        stringBuilder.append(results.get(participant).value())
                     .append(NEW_LINE);

        System.out.println(stringBuilder);
    }

    public static void printResult(List<Result> results) {
        stringBuilder.setLength(BUILDER_INITIAL_LENGTH);
        stringBuilder.append("실행 결과")
                     .append(NEW_LINE);

        results.forEach(result -> stringBuilder.append(result.getParticipant().name())
                                               .append(RESULT_SEPARATOR)
                                               .append(result.getGoal().value())
                                               .append(NEW_LINE));

        System.out.println(stringBuilder);
    }
}
