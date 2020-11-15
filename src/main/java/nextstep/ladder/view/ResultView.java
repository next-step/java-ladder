package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;

import java.io.PrintWriter;

public class ResultView {
    private static final String HAS_POINT = "-----|";
    private static final String NO_POINT = "     |";
    private static final String TITLE = "실행결과";
    private static final String NAME_FORMAT = "%6s";

    private final PrintWriter output;

    public ResultView(PrintWriter output) {
        this.output = output;
    }

    public void showResult(Ladder ladder) {
        showTitle();
        showMemberNames(ladder);
        showLines(ladder);
    }

    private void showTitle() {
        output.println(TITLE);
        output.println("");
    }

    private void showMemberNames(Ladder ladder) {
        ladder.getMemberNames().stream()
                .map(name -> String.format(NAME_FORMAT, name))
                .forEach(output::print);
        output.println("");
    }

    private void showLines(Ladder ladder) {
        ladder.getLines()
                .forEach(this::showLine);
    }

    private void showLine(nextstep.ladder.domain.ladder.Line line) {
        line.getPoints().stream()
                .map(this::convertPointToString)
                .forEach(output::print);
        output.println("");
    }

    private String convertPointToString(Boolean hasPoint) {
        if (hasPoint) {
            return HAS_POINT;
        }
        return NO_POINT;
    }
}
