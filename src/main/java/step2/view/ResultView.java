package step2.view;

import step2.*;

import java.util.List;

public class ResultView {

    private static final String LINE = "-----|";
    private static final String BLANK = " ";
    private static final String NO_LINE = "     |";
    private static final int MAX_LENGTH = 6;


    public void printPerson(Persons persons) {
        persons.personList()
                .stream()
                .map(Person::of)
                .forEach(name -> {
                    int blank = MAX_LENGTH - name.length();
                    printBlank(blank);
                    System.out.print(name);
                });
        System.out.println(BLANK);
    }

    public void printBlank(int blank) {
        for (int i = 0; i < blank; i++) {
            System.out.print(BLANK);
        }
    }

    public void printLadder(Lines lines) {

        lines.lines().stream()
                .map(Line::getPoints)
                .forEach(ResultView::printLine);
    }

    private static void printLine(List<Point> points) {
        points.forEach(
                point -> System.out.print(getLine(point.currentPoint()))
        );
        System.out.println(BLANK);
    }

    private static String getLine(boolean currentPoint) {
        if (currentPoint) {
            return LINE;
        }
        return NO_LINE;
    }


}
