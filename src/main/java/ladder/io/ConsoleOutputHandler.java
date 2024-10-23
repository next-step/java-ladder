package ladder.io;


import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Players;

import java.util.List;

import static ladder.domain.PlayerName.NAME_WIDTH;

public class ConsoleOutputHandler implements OutputHandler {

    private StringBuilder sb;

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
        sb = new StringBuilder().append("실행 결과").append(System.lineSeparator()).append(System.lineSeparator());

        printPlayers(players);

        printLadder(ladder);

        System.out.println(sb);
    }

    private void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printLine(line);
        }
    }

    private void printPlayers(Players players) {
        for (Player player : players.getPlayers()) {
            sb.append(String.format("%-7s", player.getPlayerName()));
        }
        sb.append(System.lineSeparator());
    }

    private void printLine(Line line) {
        List<Boolean> points = line.getPoints();
        sb.append("    ");
        for (Boolean point : points) {
            sb.append("|");
            if (point) {
                sb.append("-".repeat(NAME_WIDTH));
            } else {
                sb.append(" ".repeat(NAME_WIDTH));
            }
        }
        sb.append("|").append(System.lineSeparator());
    }
}
