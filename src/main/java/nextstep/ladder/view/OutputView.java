package nextstep.ladder.view;

import java.util.List;
import java.util.Map;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.player.Player;

public class OutputView {

    private final LadderView ladderView = new LadderView();

    public void printPlayerPrize(String prize) {
        System.out.println("실행 결과");
        System.out.println(prize);
        System.out.println();
    }

    public void printPlayerPrizes(Map<Player, String> playerPrizes) {
        System.out.println("실행 결과");
        playerPrizes.forEach((player, prize) -> System.out
            .println(String.format("%s : %s", player.getName(), prize)));
    }

    public void printLadder(List<Player> players, List<String> prizes, List<Line> lines) {
        System.out.println("사다리결과\n");
        ladderView.printLadder(players, prizes, lines);
    }
}

