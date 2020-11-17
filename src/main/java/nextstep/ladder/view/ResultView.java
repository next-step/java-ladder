package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Line;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String HAS_POINT = "-----|";
    private static final String NO_POINT = "     |";
    private static final String TITLE = "사다리 결과";
    private static final String NAME_FORMAT = "%6s";
    private static final String END_POINT_FORMAT = "%-6s";
    private static final String RESULT_TITLE = "실행 결과";
    private static final String END_POINT_RESULT_FORMAT = "%s : %s";

    private final PrintWriter output;

    public ResultView(PrintWriter output) {
        this.output = output;
    }

    public void showTitle() {
        output.println(TITLE);
        showNewLine();
    }

    private void showNewLine() {
        output.println("");
    }

    public void showMemberNames(List<String> memberNames) {
        memberNames.stream()
                .map(name -> String.format(NAME_FORMAT, name))
                .forEach(output::print);
        showNewLine();
    }

    public void showLadder(List<Line> lines) {
        lines.forEach(this::showLine);
    }

    private void showLine(Line line) {
        line.getPoints().stream()
                .map(this::convertPointToString)
                .forEach(output::print);
        showNewLine();
    }

    private String convertPointToString(Boolean hasPoint) {
        if (hasPoint) {
            return HAS_POINT;
        }
        return NO_POINT;
    }

    public void showEndPoints(List<String> endPoints) {
        endPoints.stream()
                .map(name -> String.format(END_POINT_FORMAT, name))
                .forEach(output::print);
        showNewLine();
        showNewLine();
    }

    public void showEndPointsOfAllMembers(Map<String, String> endPointsOfAllMembers) {
        showResultTitle();
        endPointsOfAllMembers.entrySet().stream()
                .map(endPointsOfMember -> String.format(END_POINT_RESULT_FORMAT, endPointsOfMember.getKey(), endPointsOfMember.getValue()))
                .forEach(output::println);
    }

    private void showResultTitle() {
        showNewLine();
        output.println(RESULT_TITLE);
    }

    public void showEndPointOfMember(String endPointOfMember) {
        showResultTitle();
        output.println(endPointOfMember);
        showNewLine();
    }
}
