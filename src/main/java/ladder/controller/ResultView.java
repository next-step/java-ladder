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
            for (int i = 0; i < line.getSize(); i++) {
                if (i == 0) {
                    sb.append("     ");
                }
                sb.append("|");
                if (line.getPoint(i)) {
                    sb.append("-----");
                    continue;
                }
                sb.append("     ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

}
