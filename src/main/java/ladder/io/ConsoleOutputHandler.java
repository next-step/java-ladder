package ladder.io;


import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Players;

import static ladder.domain.PlayerName.NAME_WIDTH;

public class ConsoleOutputHandler implements OutputHandler {

    public static final String BAR = "|";
    public static final String DASH = "-";
    public static final String SPACE = " ";

    @Override
    public void showCommentForNamesOfPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    @Override
    public void showCommentForHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    @Override
    public void showLadderGameResult(Players players, Ladder ladder) {
        printResultTitle();

        printPlayers(players);

        printLadder(ladder);
    }

    private void printResultTitle() {
        System.out.println("실행 결과");
        System.out.println();
    }

    private void printPlayers(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.printf("%-7s", player.getPlayerName());
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        System.out.print(SPACE.repeat(4));
        for (Boolean point : line.getPoints()) {
            System.out.print(BAR);
            drawBridge(point);
        }
        System.out.println(BAR);
    }

    private void drawBridge(Boolean point) {
        if (point) {
            System.out.print(DASH.repeat(NAME_WIDTH));
            return;
        }
        System.out.print(SPACE.repeat(NAME_WIDTH));
    }
}
