package nextstep.step2.view;

import nextstep.step2.Participant;
import nextstep.step2.Entries;
import nextstep.step2.Ladder;
import nextstep.step2.Line;

import java.util.List;

public class ResultView {

    public static void printHumans(Entries entries) {
        StringBuilder sb = new StringBuilder();
        for (Participant participant : entries.getHumanList()) {
            String name = participant.getName();
            int paddingLength = 6 - name.length();
            sb.append(" ".repeat(Math.max(0, paddingLength)));
            sb.append(name);
        }
        System.out.println(sb);
    }

    public static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        int height = lines.isEmpty() ? 0 : lines.get(0).getPoints().size();

        for (int i = 0; i < height; i++) {
            printRow(lines, i);
        }
    }

    private static void printRow(List<Line> lines, int rowIndex) {
        StringBuilder sb = new StringBuilder();
        sb.append("     ");
        for (Line line : lines) {
            sb.append("|");
            List<Boolean> points = line.getPoints();
            sb.append(points.get(rowIndex) ? "-----" : "     ");
        }
        System.out.println(sb);
    }
}
