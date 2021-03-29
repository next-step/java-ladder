package ladder.view;

import ladder.domain.Line;
import ladder.domain.LineState;
import ladder.dto.Name;

import java.util.List;

public class ResultView {

    private static final String BOUNDARY = "|";
    private static final String BLANK = " ";

    public void print(List<Name> names, List<Line> ladder) {
        System.out.println("실행결과");
        System.out.println();

        names.forEach(name -> System.out.print(name.getName() + BLANK));
        System.out.println();

        ladder.forEach(this::printLadder);
    }

    public void printLadder(Line line) {
        line.getPoints()
                .forEach(point -> System.out.print(BOUNDARY + LineState.state(point)));
        System.out.println();
    }
}
