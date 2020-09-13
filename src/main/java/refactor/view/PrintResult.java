package refactor.view;


import refactor.domain.*;

import java.util.List;


public class PrintResult {

    private static final int SEPERATE_DEFAULT = 5;

    private static final String RESULT_SEPORATOR = " : ";

    public static void makeLadder(Ladder ladder) {
        ladder.getLadderLines().stream()
                .forEach(ladderLine -> makeLadderLine(ladderLine));
    }

    public static void makeLadderLine(LadderLine ladderLine) {
        ladderLine.getPoints().stream()
                .map(Point::getDirection)
                .map(Direction::isLeft)
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
