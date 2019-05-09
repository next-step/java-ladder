package view;

import domain.*;

public class ResultView {
    public static void printLadders(Players players, Ladder ladder, Results results) {
        System.out.println("실행 결과");
        System.out.println(players.toString());
        ladder.printLadder();
        System.out.println(results.toString());
    }

    public static void showAllResults(LadderGameResult ladderGameResult) {
        System.out.println("실행 결과");
        ladderGameResult.printAll();
    }

    public static void showSinglePlayerResult(Player player, LadderGameResult ladderGameResult) {
        System.out.println("실행 결과\n" + ladderGameResult.getResultOf(player));
    }

}
