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
        printPlayResults(result.getPlayResults());
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

    private static void printPlayResults(final PlayResults playResults) {
        playResults.getPlayResults()
                .forEach(ResultView::printPlayResult);
        System.out.println();
    }

    private static void printPlayResult(final PlayResult inputPlayResult) {
        StringBuilder playResult = new StringBuilder(inputPlayResult.getValue());
        int playResultLength = playResult.length();
        for (int i = 0; i < COUNT + 1 - playResultLength; i++) {
            playResult.append(EMPTY_INDICATION);
        }
        System.out.print(playResult);
    }

    public static void print(final LadderResult ladderResult) {
        ladderResult.getResult()
                .forEach((player, playResult) -> System.out.println(player + " : " + playResult));
    }

    public static void print(final String playerName, final PlayResult playResult) {
        System.out.println("실행 결과");
        System.out.println(playerName + " : " + playResult);
    }
}