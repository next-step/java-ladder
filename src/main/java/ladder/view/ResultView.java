package ladder.view;

import java.util.List;

import ladder.domain.Line;
import ladder.domain.PersonNames;

public class ResultView {

    public static void personNames(PersonNames personNames) {
        System.out.println("\n실행결과\n");
        System.out.println(personNames.toString());
    }

    public static void result(List<Line> lines) {
        lines.forEach(line -> System.out.println(line.toString()));
    }

}
