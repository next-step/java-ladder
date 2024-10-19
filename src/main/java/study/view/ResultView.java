package study.view;


import study.core.Line;
import study.core.PlayerName;
import study.core.Prize;
import study.core.Result;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String LINE_HORIZONTAL = "-----";
    private static final String LINE_HORIZONTAL_EMPTY = "     ";
    private static final String LINE_VERTICAL = "|";
    private static final StringBuilder sb = new StringBuilder();

    public void printLadder(List<PlayerName> names, List<Line> ladder, List<Prize> results) {
        System.out.println(LADDER_RESULT_MESSAGE);
        names.forEach(name -> sb.append(String.format("%-5s", name.getName())).append(" "));
        sb.append(System.lineSeparator());
        ladder.forEach(this::printLine);
        results.forEach(result -> sb.append(String.format("%-5s", result.getValue())).append(" "));
        System.out.println(sb.toString());
        System.out.println();
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

    public void printResult(PlayerName playerName, Result result) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        if (!playerName.getName().equals("all")) {
            System.out.println(result.getResults().get(playerName).getValue());
            return;
        }
        result.getResults()
                .forEach((key, value) -> System.out.println(key.getName() + " : " + value.getValue()));
    }

}
