package nextstep.ladder.view;

import nextstep.ladder.model.ladder.Ladder;
import nextstep.ladder.model.ladder.Line;
import nextstep.ladder.model.ladder.Position;
import nextstep.ladder.model.player.Players;

import java.util.List;

public class LadderPrinter {
    private static final String LINE = "|";
    private static final String BRIDGE = "-----";
    private static final String NO_BRIDGE = "     ";

    public static void print(final Ladder ladder, final Players players) {
        printHeader(players);
        System.out.println();
        printLadder(ladder, players.count());
    }

    private static void printHeader(final Players players) {
        StringBuilder header = new StringBuilder();
        List<String> playerNames = players.getNames();
        for (int i = 0; i < playerNames.size(); i++) {
            header.append(playerNames.get(i));
            if (i < playerNames.size() - 1) {
                header.append("  ");
            }
        }
        System.out.println(header);
    }

    private static void printLadder(final Ladder ladder, final int playerCount) {
        ladder.getLines().forEach(line -> printLine(line, playerCount));
    }

    private static void printLine(final Line line, final int playerCount) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < playerCount; i++) {
            if (i == 0) {
                sb.append("    ");
            }
            
            sb.append(LINE);
            
            if (i < playerCount - 1) {
                sb.append(line.hasLine(new Position(i)) ? BRIDGE : NO_BRIDGE);
            }
        }
        
        System.out.println(sb);
    }
} 
