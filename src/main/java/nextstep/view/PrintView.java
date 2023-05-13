package nextstep.view;

import nextstep.domain.Ladder;
import nextstep.domain.Line;
import nextstep.domain.Participants;

import java.util.List;

public class PrintView {

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printParticipants(Participants participants) {
        participants.forEach(x -> System.out.printf("%6s", x));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.forEach(PrintView::printLine);
    }

    private static void printLine(Line line) {
        List<Boolean> points = line.points();

        System.out.print("     |");
        points.stream()
                .map(line::changeBooleanIntoLine)
                .forEach(x -> {
                    System.out.print(x);
                    System.out.print("|");
                });
        System.out.println();
    }
}
