package ladder.view;

import ladder.domain.Player;
import ladder.domain.Players;

public class OutputView {

    private OutputView() {}

    public static void printPlayerName(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.print(" ");
            System.out.print(formatName(player.getName()));
        }
    }

    // TODO : 테스트를 위한 public 접근 제한자, private로 수정할 것.
    public static String formatName(String name) {
        return String.format("%5s", name);
    }
}
