package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

import static ladder.domain.player.Name.MAX_LENGTH;

public class OutputView {
    public static final String CROSSABLE_STEP = "-----";
    public static final String UN_CROSSABLE_STEP = "     ";
    public static final String BEAM = "|";

    private OutputView() {
    }

    public static void printPlayers(Players players) {
        System.out.println(players);
    }

    public static String nameToDisplayingName(String name) {
        int dif = MAX_LENGTH - name.length();
        return name + " ".repeat(dif + 1);
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printReward(Reward reward) {
        System.out.println(reward);
    }

    public static void printPlayerReward(Player player, Reward reward) {
        System.out.printf("%s : %s%n", player, reward);
    }

    public static void printRewards(Rewards rewards) {
        System.out.println(rewards);
    }
}
