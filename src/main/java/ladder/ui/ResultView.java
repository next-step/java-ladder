package ladder.ui;

import ladder.domain.*;

public class ResultView {
    private ResultView() {
    }

    public static void printTitle(People people) {
        System.out.printf("실행결과%n%n");

        people.values().forEach(item -> System.out.printf(String.format("%5s ", item)));
        System.out.println();
    }

    public static void printLadder(LadderLines ladder) {
        ladder.draw().forEach(ResultView::drawLine);
    }

    public static void printEndLadder(Gifts gifts) {
        gifts.values().forEach(item -> System.out.printf(String.format("%5s ", item)));
        System.out.println();
    }

    public static void printResult(GameResult gameResult, People people) {
        while (true) {
            String text = InputView.inputPerson();

            if (checkEnd(text)) break;

            if (checkContains(people, text)) continue;

            System.out.printf("%n실행 결과%n");
            if (checkAll(text)) {
                printAll(gameResult);
                continue;
            }

            printSolo(gameResult, text);

        }

    }

    private static void printSolo(GameResult gameResult, String text) {
        System.out.printf("%s : %s%n", text, gameResult.checkResult(new Name(text)));
    }

    private static void printAll(GameResult gameResult) {
        gameResult.values().forEach((name, gift) -> System.out.printf("%s : %s%n", name, gift));
    }

    private static boolean checkContains(People people, String text) {
        if (!checkAll(text) &&!people.contains(new Name(text))) {
            System.out.println("잘못입력하셨습니다.");
            return true;
        }
        return false;
    }

    private static boolean checkEnd(String text) {
        if (text.equals(",")) {
            System.out.printf("%n종료되었습니다.%n");
            return true;
        }
        return false;
    }

    private static boolean checkAll(String text) {
        return text.equals("all");
    }


    private static void drawLine(LadderLine ladderLine) {
        ladderLine.draw().forEach(item -> System.out.print(drawCoordinate(item)));
        System.out.println();
    }

    private static String drawCoordinate(Coordinate coordinate) {
        if (coordinate.exist()) {
            return "-----|";
        }
        return "     |";
    }

}
