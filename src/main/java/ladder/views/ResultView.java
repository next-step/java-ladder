package ladder.views;

import ladder.domain.Ladder;
import ladder.domain.LadderLine;
import ladder.domain.Player;
import ladder.domain.Players;

public class ResultView {
    public static void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.height(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            LadderLine ladderLine = ladder.getLadderLine(i);
            for (int j = 0; j < ladderLine.size(); j++) {
                if (ladderLine.getPoint(j)) {
                    sb.append("-".repeat(5));
                    sb.append("|");
                } else {
                    sb.append(" ".repeat(5));
                    sb.append("|");
                }
            }
            System.out.println(sb);
        }
    }

    public static void printPlayer(Players players) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < players.count(); i++) {
            Player playerAtIndex = players.getPlayerAtIndex(i);
            String nameAtIndex = playerAtIndex.name();
            sb.append(nameAtIndex);
            sb.append(" ".repeat(6 - nameAtIndex.length()));
        }
        System.out.println(sb);
    }
}
