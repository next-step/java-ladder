package ladderWithInterface.ui;


import ladderWithInterface.custom.*;
import ladderWithInterface.engin.Ladder;
import ladderWithInterface.engin.LadderResult;
import ladderWithInterface.engin.Line;

public class ResultView {
    private ResultView() {
    }

    public static void printLadder(People people, Ladder ladder, Gifts gifts) {
        printTitle(people);
        ladder.draw().forEach(ResultView::drawLine);
        printEndLadder(gifts);

    }


    private static void printTitle(ladderWithInterface.custom.People people) {
        System.out.printf("실행결과%n%n");

        people.values().forEach(item -> System.out.printf(String.format("%5s ", item)));
        System.out.println();
    }

    private static void drawLine(Line line) {
        line.draw().forEach(item -> System.out.print(drawCoordinate(item)));
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

    public static void printGame(People people, LadderResult ladderResult, Gifts gifts) {
        while (true) {
            String text = InputView.inputPerson();

            System.out.printf("%n실행 결과%n");
            if (isAll(text)) {
                printAll(ladderResult, people, gifts);
                break;
            }

            printSolo(ladderResult, gifts, people, text);
        }
    }


    private static void printSolo(LadderResult ladderResult, Gifts gifts, People people, String text) {

        int peopleIndex = people.indexOf(new Name(text));

        if (peopleIndex == -1) {
            System.out.println("잘못입력하셨습니다.");
            return;
        }

        Gift gift = findGift(gifts, ladderResult.getTarget(peopleIndex));

        System.out.printf("%s : %s%n", text, gift);
    }

    private static boolean isAll(String text) {
        return text.equals("all");
    }

    private static void printAll(LadderResult ladderResult, People people, Gifts gifts) {

        ladderResult.values().forEach((nameIndex, giftIndex) -> System.out.printf("%s : %s%n", people.value(nameIndex), gifts.value(giftIndex)));
    }

    private static Gift findGift(Gifts gifts, int index) {
        return gifts.value(index);
    }


}
