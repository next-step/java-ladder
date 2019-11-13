package nextstep.ladder.view;

import nextstep.ladder.domain.*;

public class OutputView {
    private static final String PRINT_FORMAT = "%6s";
    private static final String PRINT_LEFT_DIRECTION = "-----|";
    private static final String PRINT_DEFAULT_DIRECTION = "     |";

    public static void printLadder(Ladder ladder, Peoples peoples) {
        printName(peoples);
        printLadder(ladder);
    }

    private static void printName(Peoples peoples) {
        for (int i = 0; i < peoples.size(); i++) {
            People people = peoples.peopleByIndex(i);
            System.out.printf(PRINT_FORMAT, people);
        }

        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        int height = ladder.height();
        for (int i = 0; i < height; i++) {
            printLaddersHeight(ladder, i);
            System.out.println();
        }
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
}
