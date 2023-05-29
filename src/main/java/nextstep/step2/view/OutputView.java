package nextstep.step2.view;

import nextstep.step2.domain.Line;
import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.Participant;
import nextstep.step2.domain.Participants;
import nextstep.step2.domain.Point;
import nextstep.step2.domain.Result;
import nextstep.step2.domain.ResultMatcher;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER = "|";
    private static final String LINE_LADDER = "-----";
    private static final String BLANK = "     ";
    private static final int PAD_BLANK = 5;
    public static final String ALL_USER = "all";

    private OutputView() {
    }

    public static void printLadderResult(Participants participants, Ladder ladder, Result result) {
        System.out.println(System.lineSeparator() + "사다리 결과");

        printParticipants(participants.getParticipants());
        printLadder(ladder.lines());
        printResult(result.getResult());
    }

    private static void printParticipants(List<Participant> participants) {
        final var names = participants.stream()
                .map(participant -> OutputView.padRight(participant.name()))
                .collect(Collectors.joining(" "));

        System.out.println(names);
    }

    private static void printLadder(List<Line> lines) {
        lines.forEach(line -> printLine(line.points()));
    }

    private static void printResult(List<String> result) {
        final var results = result.stream()
                .map(OutputView::padRight)
                .collect(Collectors.joining(" "));

        System.out.println(results);
    }

    private static String padRight(String name) {
        return String.format("%-" + PAD_BLANK + "s", name);
    }

    private static void printLine(List<Point> points) {
        final var line = points.stream()
                .map(OutputView::convertLine)
                .collect(Collectors.joining()) + LADDER;

        System.out.println(line);
    }

    private static String convertLine(Point point) {
        if (point.exist()) {
            return LADDER + LINE_LADDER;
        }

        return LADDER + BLANK;
    }

    public static void ladderGameResult(Participants participants, ResultMatcher matcher, String name) {
        System.out.println(System.lineSeparator() + "실행 결과");

        if (ALL_USER.equals(name)) {
            participants.getParticipants()
                    .forEach(participant ->
                            System.out.println(participant + " : " + matcher.match(participant.name()))
                    );
            return;
        }

        System.out.println(matcher.match(name));
    }
}
