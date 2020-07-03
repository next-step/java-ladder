package nextstep.ladder.view;

import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.List;

public class ResultView {

    private static final String STRAIGHT_LINE = "-----|";
    private static final String EMPTY_LINE = "     |";

    public void printLadder(List<String> userNames, List<Line> lines, List<String> rewards) {
        System.out.println("사다리 결과\n");

        printElements(userNames);
        printLines(lines);
        printElements(rewards);
    }

    public void printResult(String name, GameResult result) {
        if (name.equals("all")) {
            printResultAll(result);
            return;
        }

        printResultTarget(name, result);
    }

    private void printResultTarget(String name, GameResult result){
        System.out.println(result.findResult(name));
    }

    private void printResultAll(GameResult result) {
        result.findAllResult()
                .forEach((name, reward) -> System.out.println(name + " : " + reward));
    }

    private void printElements(List<String> rewards) {
        rewards.forEach(reward -> System.out.printf("%-6s", reward));
        System.out.println();
    }

    private void printLines(List<Line> lines) {
        lines.forEach(this::printPoints);
    }

    private void printPoints(Line line) {
        line.getPoints().forEach(point -> System.out.print(findLine(point)));
        System.out.println();
    }

    private String findLine(Point point) {
        if (point.isLine()) {
            return STRAIGHT_LINE;
        }

        return EMPTY_LINE;
    }
}
