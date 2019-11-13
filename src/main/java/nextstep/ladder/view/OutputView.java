package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String PRINT_FORMAT = "%6s";
    private static final String PRINT_LEFT_DIRECTION = "-----|";
    private static final String PRINT_DEFAULT_DIRECTION = "     |";
    private static final String PRINT_RESULT_TITLE = "실행 결과";
    private static final String PRINT_RESULT_FORMAT = "%s : %s";
    private static final String ALL_RESULT_KEYWORD = "all";
    private static final String ALL_RESULT_SEPARATOR = "\n";

    public static void printLadder(Ladder ladder, Peoples peoples, Gifts gifts) {
        printPeoples(peoples);
        printLadder(ladder);
        printGifts(gifts);
    }

    private static void printPeoples(Peoples peoples) {
        for (int i = 0; i < peoples.size(); i++) {
            People people = peoples.peopleByIndex(i);
            System.out.printf(PRINT_FORMAT, people);
        }

        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        int height = ladder.height();
        for (int i = 0; i < height; i++) {
            printLaddersHeight(ladder, i);
            System.out.println();
        }
    }

    private static void printGifts(Gifts gifts) {
        for (int i = 0; i < gifts.size(); i++) {
            Gift gift = gifts.giftByIndex(i);
            System.out.printf(PRINT_FORMAT, gift);
        }

        System.out.println();
    }

    private static void printLaddersHeight(Ladder ladder, int height) {
        for (int i = 0; i < ladder.size(); i++) {
            Direction direction = ladder.ladderDirection(i, height);
            printDirection(direction);
        }
    }

    private static void printDirection(Direction direction) {
        String directionCharacter = Direction.LEFT.equals(direction) ?
                PRINT_LEFT_DIRECTION : PRINT_DEFAULT_DIRECTION;

        System.out.printf(PRINT_FORMAT, directionCharacter);
    }

    //TODO 파라미터 4개인 부분은 수정 예정 입니다.
    public static void printResult(String resultName, Ladder ladder, Peoples peoples, Gifts gifts) {
        System.out.println(PRINT_RESULT_TITLE);
        String result = ALL_RESULT_KEYWORD.equalsIgnoreCase(resultName) ?
                printAllResult(ladder, peoples, gifts) : printByName(resultName, ladder, peoples, gifts);
        System.out.println(result);
    }

    private static String printAllResult(Ladder ladder, Peoples peoples, Gifts gifts) {
        return IntStream.range(0, peoples.size())
                .mapToObj(i -> result(ladder, peoples, gifts, i))
                .collect(Collectors.joining(ALL_RESULT_SEPARATOR));
    }

    private static String printByName(String resultName, Ladder ladder, Peoples peoples, Gifts gifts) {
        int peopleIndex = peoples.indexByName(resultName);
        return result(ladder, peoples, gifts, peopleIndex);
    }

    private static String result(Ladder ladder, Peoples peoples, Gifts gifts, int index) {
        Gift gift = gifts.giftByIndex(ladder.result(index));
        return String.format(PRINT_RESULT_FORMAT, peoples.peopleByIndex(index), gift);
    }
}
