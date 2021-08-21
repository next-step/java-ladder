package ladder.view;

import ladder.domain.*;

import java.util.stream.IntStream;

public class ResultView {
    private static final String POINT_INDICATION = "|";

    private static final String BRIDGE_INDICATION = "-";

    private static final String EMPTY_INDICATION = " ";

    private static final int COUNT = 5;

    public static void print(final Result result) {
        printPlayerNames(result.getPlayers());
        printLadders(result.getLadders());
    }

    private static void printPlayerNames(final Players players) {
        players.getPlayers()
                .forEach(ResultView::printPlayer);
        System.out.println();
    }

    private static void printPlayer(final Player player) {
        StringBuilder playerName = new StringBuilder(player.getName());
        int playerNameLength = playerName.length();
        IntStream.range(0, COUNT + 1 - playerNameLength)
                .mapToObj(index -> EMPTY_INDICATION)
                .forEach(playerName::append);
        System.out.print(playerName);
    }

    private static void printLadders(final Ladders ladders) {
        for (Line line : ladders.getLines()) {
            printLine(line);
            System.out.println();
        }
    }

    private static void printLine(final Line line) {
        for (Direction direction : line.getDirections()) {
            printDirection(direction);
        }
    }

    private static void printDirection(final Direction direction) {
        System.out.print(POINT_INDICATION);
        IntStream.range(0, COUNT)
                .forEach(index -> printIndication(direction));
    }

    private static void printIndication(final Direction direction) {
        if (direction.isRight()) {
            System.out.print(BRIDGE_INDICATION);
            return;
        }
        System.out.print(EMPTY_INDICATION);
    }
}