package nextstep.ladder.presentation;

import nextstep.ladder.domain.Line;

public class LineResultView {
    private static final String INITIAL_LINE_PRINT_FORMAT = "%6s";
    private static final String VERTICAL_BAR = "|";
    private final Line line;

    public LineResultView(Line line) {
        this.line = line;
    }

    public void printLine() {
        System.out.println(line());
    }

    private StringBuilder line() {
        StringBuilder printLine = initialLine();
        line.connections().stream()
                .map(ConnectionResultView::new)
                .forEach(connectionResultView -> printLine.append(connectionResultView.connection()).append(VERTICAL_BAR));

        return printLine;
    }

    private StringBuilder initialLine() {
        return new StringBuilder()
                .append(String.format(INITIAL_LINE_PRINT_FORMAT, VERTICAL_BAR));
    }
}
