package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Players;

public class OutputView {
    private static final int NAME_WIDTH = 6;
    private static final String VERTICAL = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    public static void printResult(Players players, Ladder ladder) {
        printNames(players);
        printLadder(ladder);
    }

    private static void printNames(Players players) {
        for (String name : players.namesOfPlayers()) {
            System.out.printf("%-" + NAME_WIDTH + "s", name);
        }
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.forEachLine(OutputView::printLine);
    }

    private static void printLine(Line line) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.size(); i++) {
            sb.append(VERTICAL);
            if (line.isConnected(i)) {
                sb.append(CONNECTED_LINE);
            } else {
                sb.append(EMPTY_LINE);
            }
        }
        sb.append(VERTICAL);
        System.out.println(sb);
    }
}

