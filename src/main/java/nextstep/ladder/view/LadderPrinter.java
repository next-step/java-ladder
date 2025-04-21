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
        appendPlayerNames(header, playerNames);
        System.out.println(header);
    }
    
    private static void appendPlayerNames(StringBuilder header, List<String> playerNames) {
        for (int i = 0; i < playerNames.size(); i++) {
            header.append(playerNames.get(i));
            appendSpaceIfNotLast(header, i, playerNames.size());
        }
    }
    
    private static void appendSpaceIfNotLast(StringBuilder header, int index, int size) {
        if (index < size - 1) {
            header.append("  ");
        }
    }

    private static void printLadder(final Ladder ladder, final int playerCount) {
        ladder.getLines().forEach(line -> printLine(line, playerCount));
    }

    private static void printLine(final Line line, final int playerCount) {
        StringBuilder sb = new StringBuilder();
        buildLineString(sb, line, playerCount);
        System.out.println(sb);
    }
    
    private static void buildLineString(StringBuilder sb, Line line, int playerCount) {
        for (int i = 0; i < playerCount; i++) {
            if (i == 0) {
                sb.append("    ");
            }
            
            sb.append(LINE);
            appendBridgeIfNeeded(sb, line, i, playerCount);
        }
    }
    
    private static void appendBridgeIfNeeded(StringBuilder sb, Line line, int position, int playerCount) {
        if (position < playerCount - 1) {
            sb.append(line.hasLine(new Position(position)) ? BRIDGE : NO_BRIDGE);
        }
    }
} 
