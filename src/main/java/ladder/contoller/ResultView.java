package ladder.contoller;

import ladder.domain.Line;

import java.util.List;

public class ResultView {

    public static void printLadder(List<String> strings, List<Line> lines) {
        System.out.println(strings);
        lines.forEach(line -> System.out.println(line.drawLine()));
    }
}
