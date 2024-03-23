package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;

import java.util.List;

public class OutputView {

    private static final String PIPE_LINE = "|";
    private static final String LINE = "-----";
    private static final String THREE_BLANK = "   ";
    private static final String FIVE_BLANK = "     ";
    private static final String NEW_LINE = System.lineSeparator();

    public void print(List<String> names, Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과").append(NEW_LINE);

        appendNames(sb, names);
        appendLadder(sb, ladder);

        System.out.println(sb);
    }

    private void appendNames(StringBuilder sb, List<String> names) {
        sb.append(THREE_BLANK);
        names.forEach(name -> {
            sb.append(String.format("%-6s", name));
        });
        sb.append(NEW_LINE);
    }

    private void appendLadder(StringBuilder sb, Ladder ladder) {
        List<Line> lines = ladder.getLines();

        lines.stream()
                .map(Line::getPoints)
                .forEach(points -> this.appendLine(sb, points));
    }

    private void appendLine(StringBuilder sb, List<Boolean> points) {
        sb.append(FIVE_BLANK).append(PIPE_LINE);
        points.forEach(point -> {
            sb.append(point ? LINE : FIVE_BLANK).append(PIPE_LINE);
        });
        sb.append(NEW_LINE);
    }
}
