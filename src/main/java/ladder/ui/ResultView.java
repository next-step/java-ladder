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

    public static void printResult(GameResult gameResult) {
        while (true) {
            String text = InputView.inputPerson();

            if (checkEnd(text)) {
                System.out.printf("%n종료되었습니다.%n");
                break;
            }

            System.out.printf("%n실행 결과%n");
            if (checkAll(text)) {
                gameResult.values().forEach((name, gift) -> System.out.printf("%s : %s%n", name, gift));
                continue;
            }

            System.out.printf("%s : %s%n", text, gameResult.checkResult(new Name(text)));

        }

    }

    private static boolean checkAll(String text) {
        return text.equals("all");
    }

    private static boolean checkEnd(String text) {
        return text.equals(",");
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
