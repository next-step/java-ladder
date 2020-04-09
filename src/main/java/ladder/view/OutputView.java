package ladder.view;

import ladder.domain.*;
import ladder.view.domain.LadderView;
import ladder.view.domain.PlayerView;
import ladder.view.domain.PrizeView;

public class OutputView {
    private static final String LADDER_RESULT_MESSAGE = "\n사다리 결과\n";

    private static PlayerView playerView = new PlayerView();
    private static LadderView ladderView = new LadderView();
    private static PrizeView prizeView = new PrizeView();

    private OutputView() {}

    public static void printPlayerName(Players players) {
        printLadderResultMessage();
        playerView.print(players);
        newLine();
    }

    public static void printLadder(final Ladder ladder) {
        ladderView.print(ladder);
    }

    public static void printPrize(final Prizes prizes) {
        prizeView.print(prizes);
        newLine();
        newLine();
    }

    private static void printLadderResultMessage() {
        System.out.println(LADDER_RESULT_MESSAGE);
    }

    private static void newLine() {
        System.out.println();
    }
}
