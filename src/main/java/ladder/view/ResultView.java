package ladder.view;

import ladder.domain.Line;

import java.util.List;

public class ResultView {

    public static void printLineList(List<Line> LineList) {
        for (Line line : LineList) {
            List<Boolean> points = line.getPoints();
            for (int j = 0; j < points.size(); j++) {
                if (j % 2 != 0) {
                    if (points.get(j)) {
                        System.out.print("----");
                    } else {
                        System.out.print("    ");
                    }
                } else {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
