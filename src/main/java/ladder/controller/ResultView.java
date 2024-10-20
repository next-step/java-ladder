package ladder.controller;

import ladder.domain.Line;
import ladder.domain.Member;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static ResultView INSTANCE = null;

    public ResultView() {
    }

    public static ResultView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultView();
        }
        return INSTANCE;
    }

    public void printResults(List<Member> members, List<Line> ladders) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행결과");
        sb.append(System.lineSeparator());
        sb.append(members.stream()
                .map(member -> String.format("%5s ", member))
                .collect(Collectors.joining()));
        sb.append(System.lineSeparator());


        for (Line line : ladders) {
            printLines(line, sb);
        }
        System.out.println(sb);
    }

    private void printLines(Line line, StringBuilder sb) {
        addHorizontal(false, sb);
        for (int i = 1; i < line.getSize(); i++) {
            addHorizontal(line.getPoint(i - 1), sb);
        }
        sb.append(System.lineSeparator());
    }

    private void addHorizontal(boolean isPoint, StringBuilder sb) {
        if (isPoint) {
            sb.append("-----");
            sb.append("|");
            return;
        }
        sb.append("     ");
        sb.append("|");
    }
}
