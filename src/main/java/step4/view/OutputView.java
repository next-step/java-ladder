package step4.view;

import step4.domain.*;

import java.util.Iterator;
import java.util.List;

public class OutputView {

    public static void output(LadderGame ladderGame) {
        outputPlayer(ladderGame.getPlayers());
        outputLadder(ladderGame.getLadders());
        winningPrize(ladderGame.getWinningPrizes());
    }

    public static void outputPlayer(Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        players.getPlayerList().forEach(player -> {
                    stringBuilder.append(String.format("%-6s", player.getPlayerName()));
                }
        );
        System.out.println(stringBuilder);
    }

    public static void outputLadder(Ladders ladders) {
        StringBuilder stringBuilder = new StringBuilder();
        int stepCount = 0;

        // step
        if (!ladders.getLadderList().isEmpty()) {
            stepCount = ladders.getLadderList().get(0).getLineCount();
            for (int i = 0; i < stepCount; i++) {
                printStepLine(ladders.getLadderList(), stringBuilder, i);
                stringBuilder.append("\n\r");
            }
        }
        System.out.println(stringBuilder);
    }

    private static void printStepLine(List<Ladder> ladderList, StringBuilder stringBuilder, int i) {
        int lastLadderLocation = ladderList.size();
        ladderList.forEach(
                ladder -> {
                    ladder = removeSide(i, ladder, lastLadderLocation);
                    stringBuilder.append(ladder.getLines().get(i).isCanStepable() ? "|-----" : "|     ");
                }
        );
    }

    private static Ladder removeSide(int i, Ladder ladder, int lastLadderLocation) {
        if (i == lastLadderLocation) {
            ladder.getLines().get(i).removeDirection(PointStep.RIGHT);
        }
        return ladder;
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
            winner(matchingResult.getMatchedWinningPrizeOrederByPlayerName(winner), winner);
            return;
        }
        Iterator<Player> playerIterator = matchingResult.getIterator();
        while (playerIterator.hasNext()) {
            Player player = playerIterator.next();
            winner(matchingResult.getMatchedWinningPrizeOrederByPlayerName(player.getPlayerName()), player.getPlayerName());
        }
    }

    private static void winner(String winningPrize, String player) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%-6s", player));
        stringBuilder.append(" : ");
        stringBuilder.append(winningPrize);
        stringBuilder.append("\r\n");
        System.out.println(stringBuilder);
    }

}
