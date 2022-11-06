package ladder.view;

import java.util.List;
import java.util.Map;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Name;
import ladder.domain.Point;
import ladder.domain.Prize;

public class OutputView {

    private final static String POINT = "|";
    private final static String LINK = "-----";
    private final static String UNLINK = "     ";
    private final static String ALL = "all";
    private final static int PLACE = 5;

    private OutputView() {
    }

    public static void printLadderResult(final Ladder ladder) {
        System.out.println("사다리 결과\n");
        System.out.println("-".repeat(10));
        printParticipants(ladder.getParticipants());
        System.out.println();
        ladder.getLines().forEach(OutputView::printLine);
    }

    private static void printParticipants(final List<Name> participants) {
        participants.forEach(p -> {
            System.out.print(" ".repeat(PLACE - p.toString().length()));
            System.out.print(p + " ");
        });
    }

    private static void printLine(final Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t\t");
        line.getPoints().forEach(point -> {
            stringBuilder.append(POINT);
            stringBuilder.append(checkLinked(point));
        });
        System.out.println(stringBuilder);
    }

    private static String checkLinked(final Point point) {
        if (point.isLinked()) {
            return LINK;
        }

        return UNLINK;
    }

    public static void printGameResult(final Map<Name, Prize> result, final String name) {
        System.out.println("실행결과\n");
        if (name.equals(ALL)) {
            printAllGameResult(result);
        }

        System.out.printf("%s : %s", name, result.get(new Name(name)));
    }

    private static void printAllGameResult(final Map<Name, Prize> result) {
        result.forEach(((name, prize) -> {
            System.out.printf("%s : %s", name, prize);
        }));
    }
}
