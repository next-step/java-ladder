package ladder.view;

import ladder.Ladder;
import ladder.LadderPlayers;
import ladder.LadderResult;
import ladder.Prizes;

public class OutputView {

    public static void printPlayer(LadderPlayers players) {
        System.out.println("사다리 결과  \n");

        players.getPlayers().forEach(System.out::print);
    }

    public static void printLadders(Ladder ladder) {
        System.out.println();
        ladder.getLines().forEach(System.out::println);
    }

    public static void printPrizes(Prizes prizes) {
        System.out.println(prizes.toString());
    }

    public static void printLadderGameResult2(LadderResult ladderResult, String name) {
        System.out.println("실행 결과");
        if (name.equals("all")) {
            printAllResult(ladderResult);
            return;
        }
        System.out.println(ladderResult.getResultPrize(name));
    }

    private static void printAllResult(LadderResult ladderResult) {
        for (String key : ladderResult.getLadderResult().keySet()) {
            System.out.println(key + " : " + ladderResult.getResultPrize(key));
        }
    }
}
