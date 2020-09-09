package ladder.view;

import ladder.domain.GamePerson;
import ladder.domain.Ladder;
import ladder.domain.line.Line;
import ladder.domain.Point;

import java.util.List;
import java.util.stream.IntStream;


public class PrintResult {

    private static final int SEPERATE_DEFAULT = 5;

    private static final String RESULT_SEPORATOR = " : ";

    public static void makeLadder(Ladder ladder) {
        ladder.getLines().stream()
                .forEach(line -> makeLine(line));
    }

    public static void makeLine(Line line) {
        line.getPoints().stream()
                .map(Point::isPrevPoint)
                .map(PrintResult::getHorizontalOrNot)
                .forEach(System.out::print);

        System.out.println();
    }

    private static String getHorizontalOrNot(boolean check) {
        if (check) {
            return "-----|";
        }
        return "     |";
    }

    public static void printNames(List<GamePerson> names) {
        names.stream()
                .map(GamePerson::getName)
                .map(PrintResult::printValue)
                .forEach(System.out::print);
        System.out.println();
    }

    private static String printValue(String value) {
        StringBuilder printValue = new StringBuilder(" ");
        int countValue = SEPERATE_DEFAULT - value.length();
        for (int i = 0; i < countValue; i++) {
            printValue.append(" ");
        }
        printValue.append(value);

        return printValue.toString();
    }

    public static void printResults(List<String> result) {
        result.stream()
                .map(PrintResult::printValue)
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printAllResult(List<GamePerson> gamePeople, List<String> results) {
        printPrepare();
        int length = gamePeople.size();
        for (int i = 0; i < length; i++) {
            System.out.println(gamePeople.get(i).getName() + RESULT_SEPORATOR + results.get(i));
        }
    }

    public static void printResult(String result) {
        printPrepare();
        System.out.println(result);
        System.out.println();
    }

    private static void printPrepare() {
        System.out.println("실행 결과");
    }

}
