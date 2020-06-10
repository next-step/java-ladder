package step3.view;

import step3.domain.Ladder;
import step3.domain.Ladders;
import step3.domain.Player;
import step3.domain.PointStep;

import java.util.List;

public class OutputView {

    public static void outputPlayer(List<Player> playerList) {
        StringBuilder stringBuilder = new StringBuilder();
        playerList.forEach(player -> {
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

    public static void winningPrize(String[] winningPrize) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String prize : winningPrize) {
            stringBuilder.append(String.format("%-6s", prize));
        }
        System.out.println(stringBuilder);
    }

    public static void winner(String[] winningPrize, List<Player> players) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < winningPrize.length; i++) {
            stringBuilder.append(String.format("%-6s", players.get(i).getPlayerName()));
            stringBuilder.append(" : ");
            stringBuilder.append(winningPrize[i]);
            stringBuilder.append("\n\r");
        }
        System.out.println(stringBuilder);
    }

    public static void winner(String winningPrize, String player) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%-6s", player));
        stringBuilder.append(" : ");
        stringBuilder.append(winningPrize);
        stringBuilder.append("\r\n");
        System.out.println(stringBuilder);
    }

}
