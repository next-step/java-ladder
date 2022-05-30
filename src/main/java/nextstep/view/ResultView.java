package nextstep.view;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

public class ResultView {
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-----";
    private static final String NO_BRIDGE = "     ";

    private ResultView() {
    }

    public static void printParticipant(List<String> participants) {
        participants.forEach(name -> System.out.printf("%-6s", name));
        System.out.println();
    }

    public static void print(Ladder ladder) {
        ladder.getLines()
              .forEach(line -> print(line));
    }

    private static void print(final Line line) {
        final List<Boolean> points = line.getPoints();
        points.forEach(point -> {
            System.out.print(PILLAR);
            printBridge(point);
        });
        System.out.println(PILLAR);
    }

    private static void printBridge(final Boolean bridge) {
        if (bridge) {
            System.out.print(BRIDGE);
            return;
        }
        System.out.print(NO_BRIDGE);
    }

}
