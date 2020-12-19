package nextstep.ladder.view;

import nextstep.ladder.model.Line;

import java.util.List;
import java.util.Optional;

public class ResultView {

    public void test() {

    }


    public void printLadder(String[] people, int height, List<Line> lines) {

        System.out.println("실행결과");
        System.out.println();

        for (int i = 0; i < people.length; i++) {
            System.out.printf("%6s", people[i]);
        }
        System.out.println();

        for (Line line : lines) {
            System.out.printf("%6s", "|");
            printLine(line);
            System.out.println();
        }
    }

    public void printLine(Line line) {
        List<Boolean> points = line.getPoints();

        for (boolean point : points) {
            if (point) {
                System.out.print("-----|");
                continue;
            }
            System.out.print("     |");
        }
    }
}
