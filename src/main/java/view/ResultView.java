package view;

import domain.Ladder;
import domain.Reward;
import domain.Players;

public abstract class ResultView {

    private ResultView() {
    }

    public static void printPlayers(final Players players) {
        newLine();
        System.out.println(players.toString());
    }

    private static void newLine() {
        System.out.println();
    }

    public static void printRewards(final Reward reward) {
        System.out.println(reward.toString());
    }

    public static void printLadder(final Ladder ladder) {
        System.out.println(ladder.toString());
    }

}
