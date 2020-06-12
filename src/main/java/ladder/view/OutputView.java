package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Set;

public class OutputView {
    private static final int LOOP_ZERO = 0;
    private static final int STRING_BUILDER_LENGTH_ZERO = 0;
    private static final int WORD_CHUNK_LENGTH = 5;

    private OutputView() {
    }

    public static void printPlayerNames(PlayersGroup playersGroup) {
        System.out.println(ViewMessages.RESULT_LADDER_BLUEPRINT);
        List<String> playerNames = playersGroup.getPlayerNames();
        StringBuilder stringBuilder = new StringBuilder();
        playerNames.forEach(playerName -> appendEachWord(playerName, stringBuilder));
        System.out.println(stringBuilder.toString());
    }

    public static void printGamePrizeNames(GamePrizesGroup gamePrizesGroup) {
        List<String> gamePrizeNames = gamePrizesGroup.getGamePrizeNames();
        StringBuilder stringBuilder = new StringBuilder();
        gamePrizeNames.forEach(gamePrizeName -> appendEachWord(gamePrizeName, stringBuilder));
        System.out.println(stringBuilder.toString());
    }

    private static void appendEachWord(String word, StringBuilder stringBuilder) {
        if (isFirstWord(stringBuilder)) {
            stringBuilder.append(word);
            appendBlank(word, stringBuilder);
            stringBuilder.append(ViewMessages.BLANK);
            return;
        }
        appendBlank(word, stringBuilder);
        stringBuilder.append(word).append(ViewMessages.BLANK);
    }

    private static boolean isFirstWord(StringBuilder stringBuilder) {
        return stringBuilder.length() == STRING_BUILDER_LENGTH_ZERO;
    }

    private static void appendBlank(String word, StringBuilder stringBuilder) {
        int blankLength = WORD_CHUNK_LENGTH - word.length();
        for (int i = LOOP_ZERO; i < blankLength; i++) {
            stringBuilder.append(ViewMessages.BLANK);
        }
    }

    public static void printLadder(Ladder ladder) {
        List<List<Direction>> ladderBluePrint = ladder.getLadderBluePrint();
        StringBuilder stringBuilder = new StringBuilder();
        ladderBluePrint.forEach(eachLadderLine -> appendLadderLine(eachLadderLine, stringBuilder));
        System.out.print(stringBuilder.toString());
    }

    private static void appendLadderLine(List<Direction> ladderLine, StringBuilder stringBuilder) {
        stringBuilder.append(ViewMessages.LINE_PREFIX);
        ladderLine.forEach(eachPoint -> appendPointPosition(eachPoint, stringBuilder));
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

    public static void printGameResult(GameResult gameResult, String resultPlayerName) {
        System.out.println(ViewMessages.RESULT_GAME);
        if (resultPlayerName.equals(ViewMessages.ALL)) {
            printAllResult(gameResult);
            return;
        }
        System.out.println(gameResult.getGamePrizeNameByPlayerName(resultPlayerName) + ViewMessages.NEW_LINE);
    }

    private static void printAllResult(GameResult gameResult) {
        Set<String> keySet = gameResult.getKeySet();
        keySet.forEach(playerName -> System.out.printf(ViewMessages.RESULT_ALL,
                playerName, gameResult.getGamePrizeNameByPlayerName(playerName)));
        System.out.println();
    }
}
