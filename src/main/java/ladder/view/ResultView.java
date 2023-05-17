package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.player.Players;

import java.util.Arrays;

public class ResultView {
    private static final int HORIZONTAL_CHARACTER_LENGTH = 6;

    private ResultView() {
    }

    public static void showResultMessage() {
        System.out.println("실행결과\n");
    }

    public static void showPlayers(Players players) {
        System.out.print("   ");
        players.getPlayerList()
                .forEach(player -> System.out.printf("%-6s", player.getName()));
        System.out.println();
    }

    public static void showLadder(Ladder ladder) {
        int maxHeight = ladder.getHeight();
        int maxWidth = ladder.getWidth() * HORIZONTAL_CHARACTER_LENGTH;
        char[][] ladderCharacters = new char[maxHeight][maxWidth];
        Arrays.stream(ladderCharacters).forEach(it -> Arrays.fill(it, ' '));

        for (int i = 0; i < maxHeight; i++) {
            int height = i;
            ladder.getVerticalLines()
                    .getVerticalLineSet()
                    .stream()
                    .map(it -> (it.getIndex() + 1) * HORIZONTAL_CHARACTER_LENGTH - 1)
                    .forEach(it -> ladderCharacters[height][it] = '|');

            ladder.getHorizontalLines().getHorizontalLineSetByHeight(height)
                    .forEach(horizontalLine -> {
                        int from = horizontalLine.getLeftVerticalLine().getIndex();
                        int to = horizontalLine.getRightVerticalLine().getIndex();
                        for (int j = (from + 1) * HORIZONTAL_CHARACTER_LENGTH; j < (to + 1) * HORIZONTAL_CHARACTER_LENGTH - 1; j++) {
                            ladderCharacters[height][j] = '-';
                        }
                    });
        }

        for (int i = 0; i < ladder.getHeight(); i++) {
            for (int j = 0; j < ladder.getWidth() * HORIZONTAL_CHARACTER_LENGTH; j++) {
                System.out.print(ladderCharacters[i][j]);
            }
            System.out.println();
        }
    }
}
