package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.player.PlayerPrize;

public class OutputView {

    private final LadderView ladderView = new LadderView();

    public void printLadder(Ladder ladder) {
        System.out.println("실핼결과\n");

        ladderView.printLadder(ladder);

        System.out.println();
    }

    public void printPlayerPrize(PlayerPrize prize) {
        System.out.println("실행 결과");
        System.out.println(prize.getPrize());
        System.out.println();
    }

    public void printPlayerPrizes(List<PlayerPrize> playerPrizes) {
        System.out.println("실행 결과");
        playerPrizes.forEach(
            playerPrize -> System.out.println(String
                .format("%s : %s", playerPrize.getPlayer().getName(), playerPrize.getPrize())));
    }
}

