package ladder.view;

import ladder.domain.GamePerson;
import ladder.domain.line.Line;
import ladder.domain.Point;

import java.util.List;

public class PrintResult {

    private static final int SEPERATE_DEFAULT = 5;

    public static void makeLadder(List<Line> lines) {
        lines.stream()
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
        if(check) {
            return "-----|";
        }
        return "     |";
    }

    public static void printNames(List<GamePerson> names) {
        names.stream()
                .map(GamePerson::getName)
                .map(PrintResult::printName)
                .forEach(System.out::print);
        System.out.println();
    }

    private static String printName(String name) {
        StringBuilder printValue = new StringBuilder(" ");
        int countValue = SEPERATE_DEFAULT - name.length();
        for (int i = 0; i < countValue; i++) {
            printValue.append(" ");
        }
        printValue.append(name);

        return printValue.toString();
    }
}
