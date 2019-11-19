package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Status;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void printSummary() {
        System.out.println();
        System.out.println("사다리결과");
        System.out.println();
    }

    public void printSpots(String spotString) {
        System.out.println(spotString.replace(',', ' '));
    }

    public void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printLine(line);
            System.out.println();
        }
    }

    private void printLine(Line line) {
        for (Point point : line.getPoints()) {
            printPoint(point);
        }
    }

    public void printPoint(Point point) {
        Status status = point.getStatus();
        String line = "";
        line += (status.getLeft()) ? "--" : "  ";
        line += "|";
        line += (status.getRight()) ? "--" : "  ";
        System.out.print(line);
    }

    public void printResult(Map<String, String> result, String name) {
        System.out.println();
        System.out.println("실행 결과");

        if (result.containsKey(name)) {
            System.out.println(result.get(name));
            return;
        }

        result.keySet().stream()
                .forEach(key -> System.out.println(key + " : " + result.get(key)));
    }
}
