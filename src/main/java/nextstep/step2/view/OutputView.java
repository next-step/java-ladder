package nextstep.step2.view;

import nextstep.step2.domain.Line;
import nextstep.step2.domain.Lines;
import nextstep.step2.domain.Participant;
import nextstep.step2.domain.Participants;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER = "|";
    private static final String LINE_LADDER = "-----";
    private static final String BLANK = "     ";
    private static final int PAD_BLANK = 5;

    private OutputView() {
    }

    public static void printResult(Participants participants, Lines lines) {
        System.out.println(System.lineSeparator() + "실행결과");

        printParticipants(participants.participants());
        printLadder(lines.lines());
    }

    private static void printParticipants(List<Participant> participants) {
        final var names = participants.stream()
                .map(participant -> OutputView.padRight(participant.name()))
                .collect(Collectors.joining(" "));

        System.out.println(names);
    }

    private static String padRight(String name) {
        return String.format("%-" + PAD_BLANK + "s", name);
    }

    private static void printLadder(List<Line> lines) {
        lines.forEach(line -> printLine(line.points()));
    }

    private static void printLine(List<Boolean> points) {
        final var line = points.stream()
                .map(OutputView::convertLine)
                .collect(Collectors.joining()) + LADDER;

        System.out.println(line);
    }

    private static String convertLine(Boolean point) {
        if (point) {
            return LADDER + LINE_LADDER;
        }

        return LADDER + BLANK;
    }

}
