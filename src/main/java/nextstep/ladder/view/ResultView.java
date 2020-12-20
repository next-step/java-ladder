package nextstep.ladder.view;

import nextstep.ladder.model.Line;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResultView {

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
        List<String> strLines = points.stream()
                            .map(point -> point? "-----|":"     |")
                            .collect(Collectors.toList());

        for(String strLine : strLines){
            System.out.print(strLine);
        }
    }
}
