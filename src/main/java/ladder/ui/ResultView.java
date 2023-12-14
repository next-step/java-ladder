package ladder.ui;

import ladder.domain.*;

public class ResultView {
    private ResultView() {
    }

    public static void printLadder(People people, LadderLines ladder, Gifts gifts) {
        printTitle(people);
        ladder.draw().forEach(ResultView::drawLine);
        printEndLadder(gifts);

    }


    private static void printTitle(People people) {
        System.out.printf("실행결과%n%n");

        people.values().forEach(item -> System.out.printf(String.format("%5s ", item)));
        System.out.println();
    }

    private static void drawLine(LadderLine ladderLine) {
        ladderLine.draw().forEach(item -> System.out.print(drawCoordinate(item)));
        System.out.println();
    }

    private static String drawCoordinate(Direction direction) {
        if (direction.isLeft()) {
            return "-----|";
        }
        return "     |";
    }

    private static void printEndLadder(Gifts gifts) {
        gifts.values().forEach(item -> System.out.printf(String.format("%5s ", item)));
        System.out.println();
    }

    public static void printGame(GameResult gameResult) {
        while (true) {
            String text = InputView.inputPerson();

            if (isEnd(text)) {
                break;
            }

            System.out.printf("%n실행 결과%n");
            printGameResult(gameResult, text);

        }
    }

    private static boolean isEnd(String text) {
        if (text.equals(",")) {
            System.out.printf("%n종료되었습니다.%n");
            return true;
        }
        return false;
    }

    private static void printGameResult(GameResult gameResult, String text) {
        if (isAll(text)) {
            printAll(gameResult);
            return;
        }
        printSolo(gameResult, text);
    }

    private static boolean isAll(String text) {
        return text.equals("all");
    }

    private static void printAll(GameResult gameResult) {
        gameResult.values().forEach((name, gift) -> System.out.printf("%s : %s%n", name, gift));
    }

    private static void printSolo(GameResult gameResult, String text) {
        Gift gift = findGift(gameResult, text);

        if (gift == null) {
            System.out.println("잘못입력하셨습니다.");
            return;
        }

        System.out.printf("%s : %s%n", text, gift);
    }

    private static Gift findGift(GameResult gameResult, String text) {
        return gameResult.checkResult(new Name(text));
    }


}
