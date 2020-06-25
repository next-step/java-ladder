package step4.view;

import step4.domain.MatchingResult;
import step4.domain.Player;
import step4.domain.Players;
import step4.domain.WinningPrizes;
import step4.refactoring.Ladder;
import step4.refactoring.Point;

import java.util.Iterator;
import java.util.List;

public class OutputView {

    public static void output(Players players, WinningPrizes winningPrizes, step4.refactoring.Ladder ladder) {
        outputPlayer(players);
        outputLadder(ladder);
        winningPrize(winningPrizes);
    }

    public static void outputPlayer(Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        players.getPlayerList().forEach(player -> {
                    stringBuilder.append(String.format("%-6s", player.getPlayerName()));
                }
        );
        System.out.println(stringBuilder);
    }

    public static void outputLadder(Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        ladder.getLines().forEach(ladderLine -> {
                    outputLadderPoint(ladderLine.getPoints());
                }
        );
        System.out.println(stringBuilder);
    }

    private static void outputLadderPoint(List<Point> points) {
        points.forEach(point -> System.out.print(hasLine(point)));
        System.out.println();
    }

    private static String hasLine(Point point) {
        return point.isRight() ? "|-----" : "|     ";
     }

    public static void winningPrize(WinningPrizes winningPrize) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < winningPrize.size(); i++) {
            stringBuilder.append(String.format("%-6s", winningPrize.get(i)));
        }
        System.out.println(stringBuilder);
    }

    public static void outputResultView(MatchingResult matchingResult) {
        // print winner
        boolean keepViewing = true;
        while (keepViewing) {
            String winner = InputView.inputNameWhoWinning();
            resultView(winner, matchingResult);
            keepViewing = isKeepViewing(keepViewing, winner);
        }
    }

    private static boolean isKeepViewing(boolean keepViewing, String winner) {
        if (winner.equals(InputView.EXIT_KEY)) {
            keepViewing = false;
        }
        return keepViewing;
    }

    private static void resultView(String winner, MatchingResult matchingResult) {
        if (!winner.equals("all")) {
            winner(winner, matchingResult.getMatchedWinningPrizeOrederByPlayerName(winner));
            return;
        }
        Iterator<Player> playerIterator = matchingResult.getIterator();
        while (playerIterator.hasNext()) {
            Player player = playerIterator.next();
            winner(player.getPlayerName(), matchingResult.getMatchedWinningPrizeOrederByPlayerName(player.getPlayerName()));
        }
    }

    private static void winner(String player, String winningPrize) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%-6s", player));
        stringBuilder.append(" : ");
        stringBuilder.append(winningPrize);
        stringBuilder.append("\r\n");
        System.out.println(stringBuilder);
    }

}
