package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Point;

public class ResultView {
    private static final String INPUT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_START = "|";
    private static final String LADDER_POINT = "-----|";
    private static final String EMPTY_POINT = "     |";
    private static final String PRINT_NAME = "%-6s";

    public static void printInputName() {
        System.out.println(INPUT_NAME_MESSAGE);
    }

    public static void printInputHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
    }

    public static void printPlayerNames(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.printf(PRINT_NAME, player.getName());
        }
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        StringBuilder lineOutput = new StringBuilder(LADDER_START);
        for (Point point : line.getPoints()) {
            lineOutput = generateLine(lineOutput, point);
        }
        System.out.println(lineOutput);
    }

    private static StringBuilder generateLine(StringBuilder lineOutput, Point point) {
        if (point.isPoint()) {
            lineOutput.append(LADDER_POINT);
        } else {
            lineOutput.append(EMPTY_POINT);
        }
        return lineOutput;
    }
}
