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
        StringBuilder printFormatOfLine = initialPrintFormatOfLine();
        line.connections().stream()
                .map(ConnectionResultView::new)
                .forEach(connectionResultView -> printFormatOfLine.append(connectionResultView.connection()).append(VERTICAL_BAR));

        System.out.println(printFormatOfLine);
    }

    private StringBuilder initialPrintFormatOfLine() {
        return new StringBuilder()
                .append(String.format(INITIAL_LINE_PRINT_FORMAT, VERTICAL_BAR));
    }
}
