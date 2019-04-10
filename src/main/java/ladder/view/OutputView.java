package ladder.view;

import ladder.*;

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

    public static void printLadderGameResult(LadderResult ladderResult, String name) {
        System.out.println("실행 결과");
        while (!name.isEmpty()) {
            if (name.equals("all")) {
                printAllResult(ladderResult);
                return;
            }
            System.out.println(ladderResult.getResultPrize(name));
        }
    }

    private static void printAllResult(LadderResult ladderResult) {
        for (Player player : ladderResult.getLadderResult().keySet()) {
            System.out.println(player.getName() + " : " + ladderResult.getLadderResult().get(player));
        }
    }
}
