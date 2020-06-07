package step2.view;

import step2.domain.Ladder;
import step2.domain.Ladders;
import step2.domain.Player;
import step2.domain.Pointer;

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
                    stringBuilder.append(ladder.getLineList().get(i).isStep() ? "|-----" : "|     ");
                }
        );

    }

    private static Ladder removeSide(int i, Ladder ladder, int lastLadderLocation) {

        if(i == lastLadderLocation) {
            ladder.getLineList().get(i).removeDirection(Pointer.RIGHT);
        }

        return ladder;

    }
}
