package nextstep.ladder.view;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.People;
import nextstep.ladder.domain.Peoples;

public class OutputView {
    private static final String PRINT_FORMAT = "%6s";
    private static final String PRINT_LEFT_DIRECTION = "-----|";
    private static final String PRINT_DEFAULT_DIRECTION = "     |";

    public static void printLadder(LadderGame ladderGame, Peoples peoples) {
        printName(peoples);
        printLadder(ladderGame);
    }

    private static void printName(Peoples peoples) {
        for (int i = 0; i < peoples.size(); i++) {
            People people = peoples.peopleByIndex(i);
            System.out.printf(PRINT_FORMAT, people);
        }

        System.out.println();
    }

    private static void printLadder(LadderGame ladderGame) {
        int height = ladderGame.height();
        for (int i = 0; i < height; i++) {
            printLaddersHeight(ladderGame, i);
            System.out.println();
        }
    }

    private static void printLaddersHeight(LadderGame ladderGame, int height) {
        for (int i = 0; i < ladderGame.size(); i++) {
            Direction direction = ladderGame.ladderDirection(i, height);
            printDirection(direction);
        }
    }

    private static void printDirection(Direction direction) {
        String directionCharacter = Direction.LEFT.equals(direction) ?
                PRINT_LEFT_DIRECTION : PRINT_DEFAULT_DIRECTION;

        System.out.printf(PRINT_FORMAT, directionCharacter);
    }
}
