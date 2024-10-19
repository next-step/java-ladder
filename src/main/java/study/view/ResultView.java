package study.view;


import study.core.Line;
import study.core.PlayerName;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String LINE_HORIZONTAL = "-----";
    private static final String LINE_HORIZONTAL_EMPTY = "     ";
    private static final String LINE_VERTICAL = "|";
    private static final StringBuilder sb = new StringBuilder();

    public void printLadder(List<PlayerName> names, List<Line> ladder) {
        System.out.println(RESULT_MESSAGE);
        names.forEach(name -> sb.append(String.format("%-5s", name.getName())).append(" "));
        sb.append(System.lineSeparator());
        ladder.forEach(this::printLine);
        System.out.println(sb.toString());
    }

    public void printLine(Line line) {
        sb.append(LINE_HORIZONTAL_EMPTY);
        line.getPoints().forEach(point -> {
            sb.append(LINE_VERTICAL);
            if (!point) {
                sb.append(LINE_HORIZONTAL_EMPTY);
                return;
            }
            sb.append(LINE_HORIZONTAL);
        });
        sb.append(LINE_VERTICAL).append(System.lineSeparator());
    }

}
