package ladder.console;

import ladder.application.LadderService;
import ladder.domain.*;

import java.util.Scanner;

public class LadderConsole {
    private static final Scanner CONSOLE_SCANNER = new Scanner(System.in);
    private static final String VERTICAL_DISPLAY = "|";
    private static final String HORIZON_DISPLAY = "-----";
    private static final String OUTPUT_FORMAT = "%6s";

    public static void run(final LadderService ladderService) {
        final LadderGame ladderGame = ladderService.make(enterInputName(), enterHeight());
        printLadderGame(ladderGame);
    }

    private static String enterInputName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return CONSOLE_SCANNER.next();
    }

    private static int enterHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return CONSOLE_SCANNER.nextInt();
    }

    private static void printLadderGame(final LadderGame ladderGame) {
        System.out.println("\n실행결과");
        printPlayers(ladderGame.getPlayers());
        printLines(ladderGame.getLines());
    }

    private static void printPlayers(final Players players) {
        final StringBuilder builder = new StringBuilder("\n");
        for (int index = 0; index < players.getNumberOfPlayers(); index++) {
            builder.append(changeToPlayerPrintFormat(players.getPlayer(index)));
        }
        System.out.println(builder.toString());
    }

    private static void printLines(final Lines lines) {
        for (int index = 0; index < lines.getHeight(); index++) {
            System.out.println(changeToLinePrintFormat(lines.getLine(index)));
        }
    }

    private static String changeToPlayerPrintFormat(final Player player) {
        return String.format(OUTPUT_FORMAT, player.getName());
    }

    private static String changeToLinePrintFormat(final Line line) {
        final StringBuilder builder = new StringBuilder();
        for (int index = 0; index < line.getLength(); index++) {
            builder.append(changeToPointPrintFormat(line.getPoint(index)));
        }
        return builder.toString();
    }

    private static String changeToPointPrintFormat(final Point point) {
        final StringBuilder builder = new StringBuilder();
        if (point.canMoveLeft()) {
            builder.append(HORIZON_DISPLAY);
        }
        builder.append(VERTICAL_DISPLAY);
        return String.format(OUTPUT_FORMAT, builder.toString());
    }
}
