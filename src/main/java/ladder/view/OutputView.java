package ladder.view;

import ladder.domain.Direction;
import ladder.domain.Ladder;
import ladder.domain.PlayersGroup;

import java.util.List;

public class OutputView {
    private static final int LOOP_ZERO = 0;
    private static final int BLANK_BOUNDARY = 0;
    private static final int NAME_CHUNK_LENGTH = 5;

    private OutputView() {
    }

    public static void printPlayerNames(PlayersGroup playersGroup) {
        List<String> playerNames = playersGroup.getPlayerNames();
        StringBuilder stringBuilder = new StringBuilder();
        playerNames.forEach(playerName -> appendEachPlayerName(playerName, stringBuilder));
        System.out.println(stringBuilder.toString());
    }

    private static void appendEachPlayerName(String playerName, StringBuilder stringBuilder) {
        if (stringBuilder.length() > BLANK_BOUNDARY) {
            appendBlank(playerName, stringBuilder);
            stringBuilder.append(playerName);
        }
        if (stringBuilder.length() == BLANK_BOUNDARY) {
            stringBuilder.append(playerName);
            appendBlank(playerName, stringBuilder);
        }
        stringBuilder.append(ViewMessages.BLANK);
    }

    private static void appendBlank(String playerName, StringBuilder stringBuilder) {
        int blankLength = NAME_CHUNK_LENGTH - playerName.length();
        for (int i = LOOP_ZERO; i < blankLength; i++) {
            stringBuilder.append(ViewMessages.BLANK);
        }
    }

    public static void printLadder(Ladder ladder) {
        List<List<Direction>> ladderBluePrint = ladder.getLadderBluePrint();
        StringBuilder stringBuilder = new StringBuilder();
        ladderBluePrint.forEach(eachLadderLine -> appendLadderLine(eachLadderLine, stringBuilder));
        System.out.println(stringBuilder.toString());
    }

    private static void appendLadderLine(List<Direction> ladderLine, StringBuilder stringBuilder) {
        stringBuilder.append(ViewMessages.LINE_PREFIX);
        int size = ladderLine.size() - 1;
        for (int i = 0; i < size; i++) {
            appendPointPosition(ladderLine.get(i), stringBuilder);
        }
        stringBuilder.append(ViewMessages.VERTICAL_LINE);
        stringBuilder.append(ViewMessages.NEW_LINE);
    }

    private static void appendPointPosition(Direction pointDirection, StringBuilder stringBuilder) {
        stringBuilder.append(ViewMessages.VERTICAL_LINE);
        if (pointDirection == Direction.RIGHT) {
            stringBuilder.append(ViewMessages.HORIZON_LINE);
            return;
        }
        stringBuilder.append(ViewMessages.BLANK_LINE);
    }
}
