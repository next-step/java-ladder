package ladder.ui;

import ladder.domain.Ladder;
import ladder.domain.PrizeTable;
import ladder.domain.Row;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String COLUMN_MARKER = "|";
    private static final String LINK_MARKER = "-----";
    private static final String SPACE       = "     ";
    private static final String PRIZE_ALL = "all";

    public static void showLadder(List<String> attendees, Ladder ladder, List<String> prizes) {
        showLabels(attendees);
        showRows(ladder.getRows());
        showLabels(prizes);
    }

    private static void showLabels(List<String> labels) {
        String outputLine = labels.stream()
                .map(OutputView::centered)
                .collect(Collectors.joining(" "));
        System.out.println(outputLine);
    }

    private static String centered(String text) {
        int length = text.codePoints()
                .map(c -> c < 128 ? 1 : 2)
                .reduce(0, Integer::sum);
        int margin = SPACE.length() - length;
        return SPACE.substring(0, margin / 2) +
                text +
                SPACE.substring(0, (margin + 1) / 2);
    }

    private static void showRows(List<Row> rows) {
        rows.stream()
                .map(OutputView::rowToString)
                .forEach(System.out::println);
    }

    private static String rowToString(Row row) {
        StringBuilder sb = new StringBuilder("  ").append(COLUMN_MARKER);
        row.getLinks().stream()
                .map(link -> link ? LINK_MARKER : SPACE)
                .forEach(marker -> sb.append(marker).append(COLUMN_MARKER));
        return sb.toString();
    }

    public static void showPrize(PrizeTable prizeTable, String whosePrize) {
        if (!PRIZE_ALL.equals(whosePrize) && prizeTable.contains(whosePrize)) {
            System.out.println("실행 결과");
            System.out.println(prizeTable.getPrize(whosePrize));
            return;
        }

        System.out.println("실행 결과");
        prizeTable.forEach((who, prize) -> {
            System.out.format("%s: ", who);
            System.out.println(prize);
        });
    }
}
