package ladder;

import java.util.List;

public class ResultView {

    private static final String LINE = "-----";
    private static final String NON_LINE = "     ";
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
        line.getPoints().forEach(point -> System.out.print(content(point)));
        System.out.println();
    }

    public String content(Boolean point) {
        System.out.print(BOUNDARY);
        if (point) {
            return LINE;
        }
        return NON_LINE;
    }
}
