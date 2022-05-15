package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;

public class OutputView {
    public static final String CROSSABLE_STEP = "-----";
    public static final String UN_CROSSABLE_STEP = "     ";
    public static final String BEAM = "|";

    private OutputView() {
    }

    public static void printPlayers(Players players) {
        System.out.println(players);
    }


    public static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    public static void printRewards(Rewards rewards) {
        System.out.println(rewards);
    }
}
