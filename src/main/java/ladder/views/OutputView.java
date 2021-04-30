package ladder.views;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String POINT = "|";
    private static final String CONNECTION_LINE = "-----";
    private static final String EMPTY_SPACE = "     ";
    private static final String EMPTY_STRING = "";
    private static final String NO_SEARCH_MESSAGE = "일치하는 사람이 없습니다.";

    public static void printLadderResultMessage() {
        System.out.println("\n사다리 결과");
    }

    public static void print(People people) {
        System.out.println();
        for (final Person person : people) {
            System.out.printf("%-" + (Person.MAX_NAME_LENGTH + 1) + "s", person.name());
        }
        System.out.println();
    }

    public static void print(Prizes prizes) {
        for (final Prize prize : prizes) {
            System.out.printf("%-" + (Person.MAX_NAME_LENGTH + 1) + "s", prize.prize());
        }
        System.out.println();
    }

    public static void print(Ladder ladder) {
        for (final LadderLine ladderLine : ladder.ladderLines()) {
            print(ladderLine);
        }
    }

    private static void print(LadderLine ladderLine) {
        final List<Point> points = ladderLine.points();

        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < points.size(); i++) {
            sb.append(view(points.get(i), i == points.size() - 1));
        }

        System.out.println(sb);
    }

    private static String view(Point point, boolean last) {
        if (last) {
            return POINT;
        }

        if (point.right()) {
            return POINT + CONNECTION_LINE;
        }

        return POINT + EMPTY_SPACE;
    }

    public static void print(LadderResults ladderResults, String name) {
        System.out.println("\n실행 결과");
        System.out.println(view(ladderResults, name));
    }

    private static String view(LadderResults ladderResults, String name) {
        if (name.equals("all")) {
            return ladderResults.stream()
                    .map(OutputView::toString)
                    .collect(Collectors.joining("\n"));
        }

        return ladderResults.stream()
                .filter(ladderResult -> ladderResult.name().equals(new Person(name)))
                .findFirst()
                .map(ladderResult -> ladderResult.prize().prize())
                .orElse(NO_SEARCH_MESSAGE);
    }

    private static String toString(LadderResult ladderResult) {
        return String.format("%s : %s", ladderResult.name().name(), ladderResult.prize().prize());
    }
}
