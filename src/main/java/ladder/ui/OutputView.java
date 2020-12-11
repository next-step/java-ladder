package ladder.ui;

import ladder.domain.Ladder;
import ladder.domain.Row;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String COLUMN_MARKER = "|";
    private static final String LINK_MARKER = "-----";
    private static final String SPACE       = "     ";

    public static void showAttendees(List<String> attendees) {
        String outputLine = attendees.stream()
                .map(OutputView::centered)
                .collect(Collectors.joining(" "));
        System.out.println(outputLine);
    }

    private static String centered(String text) {
        int margin = SPACE.length() - text.length();
        return SPACE.substring(0, margin / 2) +
                text +
                SPACE.substring(0, (margin + 1) / 2);
    }

    public static void showLadder(Ladder ladder) {
        ladder.stream()
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
}
