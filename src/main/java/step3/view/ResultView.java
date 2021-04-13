package step3.view;

import step3.Result;
import step3.domain.*;

import java.util.List;

public class ResultView {

    private static final String LINE = "|-----";
    private static final String BLANK = " ";
    private static final int EMPTY = 5;
    private static final String NO_LINE = "|     ";
    private static final int MAX_LENGTH = 6;


    public void printPerson(Persons persons) {
        persons.personList()
                .stream()
                .map(Person::toString)
                .forEach(name -> {
                    int blank = MAX_LENGTH - name.length();
                    printBlank(blank);
                    System.out.print(name);
                });
        System.out.println(BLANK);
    }

    public static void printBlank(int blank) {
        for (int i = 0; i < blank; i++) {
            System.out.print(BLANK);
        }
    }

    public void printLadder(Lines lines) {

        lines.lines().stream()
                .map(Line::row)
                .forEach(ResultView::printLine);
        System.out.println(BLANK);
    }

    private static void printLine(List<Point> points) {
        printBlank(EMPTY);
        points.forEach(
                point -> System.out.print(getLine(point))
        );
        System.out.println();
    }

    private static String getLine(Point point) {
        Location location = point.location();
        if (location.isRight()) {
            return LINE;
        }
        return NO_LINE;
    }

    public void executionResultLine(Result result) {
        result.all()
                .stream()
                .map(ExecutionResult::toString)
                .forEach(name -> {
                    int blank = MAX_LENGTH - name.length();
                    printBlank(blank);
                    System.out.print(name);
                });
        System.out.println(BLANK);
    }

    public void printExecutionResult(Result result, Person person) {
        System.out.println("실행 결과");
        System.out.println(result.get(person));
        System.out.println(BLANK);
    }

    public void printAllExecutionResult(Result result) {

        System.out.println("실행 결과");
        result.of()
                .forEach((k, v) -> {
                    System.out.println(k.toString() + " : " + result.get(k));
                });
        System.out.println(BLANK);
    }
}
