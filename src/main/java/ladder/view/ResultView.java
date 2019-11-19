package ladder.view;

import ladder.domain.*;

import java.util.List;

public class ResultView {
    private static final String LADDER_LINE = "|     ";
    private static final String LADDER_POINT = "|-----";
    private static final String INTERVAL = " ";

    private ResultView() {

    }

    public static void print(Ladder ladder) {
        System.out.println("사다리 결과");
        printPeople(ladder.getPeople());
        printAllLines(ladder.getLadderLines());
        printResults(ladder.getResults());
    }

    private static void printResults(List<Result> results) {
        results.stream()
                .filter(Result::isNameLength)
                .forEach(result ->
                        System.out.print(result.getName() + printEmptyForCorrection(result.getEmptyLength())));
        System.out.println();
    }

    private static void printPeople(List<Person> people) {
        people.stream()
                .filter(Person::isNameLength)
                .forEach(person ->
                        System.out.print(person.getName() + printEmptyForCorrection(person.getEmptyLength())));
        System.out.println();
    }

    private static String printEmptyForCorrection(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(INTERVAL);
        }
        return stringBuilder.toString();
    }

    private static void printAllLines(List<Line> lines) {
        for (Line line : lines) {
            printLines(line.getPoints());
            System.out.println();
        }
    }

    private static void printLines(List<Point> ladderPoints) {
        for (Point ladderPoint : ladderPoints) {
            System.out.print(printPoint(ladderPoint));
        }
    }

    private static String printPoint(Point point) {
        if (point.getType()) {
            return LADDER_POINT;
        }
        return LADDER_LINE;
    }

    public static void printResult(Ladder ladder) {
        System.out.println("실행결과");
        for (Person person : ladder.getPeople()) {
            System.out.println(person.getName() + " : " + ladder.getResultValue(person.getPosition()));
        }
    }

    public static void printResultOfAll(String resultName) {
        System.out.println("실행결과");
        System.out.println(resultName);
    }
}
