package nextstep.ladder.view;

import nextstep.ladder.domain.*;

public class OutputView {
    private static final String PRINT_FORMAT = "%6s";
    private static final String PRINT_LEFT_DIRECTION = "-----|";
    private static final String PRINT_DEFAULT_DIRECTION = "     |";

    public static void printLadder(Ladders ladders, Peoples peoples) {
        printName(peoples);
        printLadder(ladders);
    }

    private static void printName(Peoples peoples) {
        for (int i = 0; i < peoples.size(); i++) {
            People people = peoples.peopleByIndex(i);
            System.out.printf(PRINT_FORMAT, people);
        }

        System.out.println();
    }

    private static void printLadder(Ladders ladders) {
        int height = ladders.height();
        for (int i = 0; i < height; i++) {
            printLaddersHeight(ladders, i);
            System.out.println();
        }
    }

    private static void printLaddersHeight(Ladders ladders, int height) {
        for (int i = 0; i < ladders.size(); i++) {
            Direction direction = ladders.ladderDirection(i, height);
            printDirection(direction);
        }
    }

    private static void printDirection(Direction direction) {
        String directionCharacter = Direction.LEFT.equals(direction) ?
                PRINT_LEFT_DIRECTION : PRINT_DEFAULT_DIRECTION;

        System.out.printf(PRINT_FORMAT, directionCharacter);
    }
}
