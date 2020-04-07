package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.VerticalLines;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String PLAYER_NAME_FORMAT = "%6s";
    private static final String LADDER_LINE_EXSIT = "|-----";
    private static final String LADDER_LINE_NONE = "|     ";

    public static void viewSettingLadder(Players players, Ladder ladder) {
        System.out.println("\n실행결과\n");
        viewPlayers(players);
        viewLadder(ladder);
    }

    private static void viewPlayers(Players players) {
        System.out.println(
                players.getPlayers().stream()
                        .map(n -> getNameWithFormat(n.getName()))
                        .collect(Collectors.joining())
        );
    }

    private static String getNameWithFormat(String name) {
        return String.format(PLAYER_NAME_FORMAT, name);
    }

    private static void viewLadder(Ladder ladder) {
        IntStream.rangeClosed(1, ladder.getHeight())
                .forEach(i -> viewLineByHeight(ladder.getVerticalLines(), i));
    }

    private static void viewLineByHeight(VerticalLines verticalLines, int height) {
        System.out.print("     ");
        IntStream.rangeClosed(1, verticalLines.getSize())
                .forEach(i -> printLines(verticalLines.getLine(i).isDrawing(height)));
        System.out.println();
    }

    private static void printLines(boolean isExistLine) {
        if (isExistLine) {
            System.out.print(LADDER_LINE_EXSIT);
            return;
        }
        System.out.print(LADDER_LINE_NONE);
    }
}
