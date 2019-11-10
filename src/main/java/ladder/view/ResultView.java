package ladder.view;

import ladder.game.Ladder;
import ladder.game.LadderGame;

import java.util.Collections;
import java.util.List;

public class ResultView {
    public static void show(LadderGame ladderGame) {
        System.out.println("실행결과");
        showParticipant(ladderGame.getParticipants());
        drawLadder(ladderGame.getLadder());
    }

    private static void showParticipant(List<String> participants) {
        for (String participant : participants) {
            int left = (6 - participant.length()) / 2;
            int right = 6 - participant.length() - left;
            System.out.print(String.join("", Collections.nCopies(left, " ")));
            System.out.print(participant);
            System.out.print(String.join("", Collections.nCopies(right, " ")));
        }
        System.out.println();
    }

    private static void drawLadder(Ladder ladder) {
        boolean[][] ladderTable = ladder.getLadder();
        for (boolean[] line : ladderTable) {
            System.out.print("  |");
            for (boolean value : line) {
                if (value) {
                    System.out.print("-----|");
                } else {
                    System.out.print("     |");
                }
            }
            System.out.println();
        }

        System.out.println();
    }
}
