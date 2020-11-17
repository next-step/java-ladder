package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Line;

import java.io.PrintWriter;
import java.util.List;

public class ResultView {
    private static final String HAS_POINT = "-----|";
    private static final String NO_POINT = "     |";
    private static final String TITLE = "실행결과";
    private static final String NAME_FORMAT = "%6s";

    private final PrintWriter output;

    public ResultView(PrintWriter output) {
        this.output = output;
    }

    public void showTitle() {
        output.println(TITLE);
        output.println("");
    }

    public void showMemberNames(List<String> memberNames) {
        memberNames.stream()
                .map(name -> String.format(NAME_FORMAT, name))
                .forEach(output::print);
        output.println("");
    }

    public void showLadder(List<Line> lines) {
        lines.forEach(this::showLine);
    }

    private void showLine(Line line) {
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
