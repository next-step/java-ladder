package nextstep.laddergame.view;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.IntStream;

import nextstep.laddergame.model.Goal;
import nextstep.laddergame.model.LadderLine;
import nextstep.laddergame.model.Participant;
import nextstep.laddergame.model.Point;
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

    public static void printLadder(List<Participant> participants, List<LadderLine> ladder, List<Goal> goals) {
        stringBuilder.setLength(BUILDER_INITIAL_LENGTH);
        stringBuilder.append("사다리 결과")
                     .append(NEW_LINE);

        printParticipants(participants);
        printLadder(ladder);
        printGoals(goals);

        System.out.println(stringBuilder);
    }

    private static void printParticipants(List<Participant> participants) {
        participants.forEach(participant -> stringBuilder.append(participant.name())
                                                         .append(DELIMITER));
        stringBuilder.append(NEW_LINE);
    }

    private static void printLadder(List<LadderLine> ladder) {
        ladder.forEach(line -> printLine(line));
    }

    private static void printLine(LadderLine line) {
        stringBuilder.append(DELIMITER);
        line.getPoints()
            .forEach(point -> printPoint(point));
        stringBuilder.append(NEW_LINE);
    }

    private static void printGoals(List<Goal> goals) {
        goals.forEach(goal -> stringBuilder.append(goal.value())
                                           .append(DELIMITER));
        stringBuilder.append(NEW_LINE);
    }

    private static StringBuilder printPoint(Point point) {
        stringBuilder.append(VERTICAL);
        String line = point.isRight() ? LINE : EMPTY;
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

    public static void printResult(List<Entry<Participant, Goal>> results) {
        stringBuilder.setLength(BUILDER_INITIAL_LENGTH);
        stringBuilder.append("실행 결과")
                     .append(NEW_LINE);

        results.forEach(result -> stringBuilder.append(result.getKey().name())
                                               .append(RESULT_SEPARATOR)
                                               .append(result.getValue().value())
                                               .append(NEW_LINE));

        System.out.println(stringBuilder);
    }
}
