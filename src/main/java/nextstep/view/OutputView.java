package nextstep.view;

import nextstep.domain.Line;
import nextstep.domain.Lines;
import nextstep.domain.Username;

import java.util.List;

public class OutputView {

    private static final String PILLAR = "|";
    private static final String FOODHOLDER = "-";

    public static void outputUserNames(List<String> usernames) {
        usernames.forEach(name -> System.out.print(
                " ".repeat(Username.LENGTH_MAX - name.length()) + name + " "));
    }

    public static void outputLadder(Lines lines) {
        lines.getLines().forEach(OutputView::outputLine);
    }

    private static void outputLine(Line line) {
        System.out.printf("%n" + " ".repeat(Username.LENGTH_MAX - 1) + PILLAR);
        for (boolean point : line.getPoints()) {
            if (point) {
                System.out.print(FOODHOLDER.repeat(Username.LENGTH_MAX) + PILLAR);
                continue;
            }
            System.out.print(" ".repeat(Username.LENGTH_MAX) + PILLAR);
        }
    }
}
