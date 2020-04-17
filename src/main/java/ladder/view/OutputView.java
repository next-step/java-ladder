package ladder.view;

import ladder.game.ui.LadderGame;
import ladder.ladder.domain.Ladder;
import ladder.ladder.domain.LadderLine;
import ladder.ladder.domain.Point;
import ladder.player.domain.Player;
import ladder.prize.domain.Prize;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class OutputView {
    private static final int ZERO = 0;
    private static final String LADDER_MARKER = "|";
    private static final String LINE_MARKER = "-";
    private static final String BLANK_MARKER = " ";
    private static final String CARRIAGE_RETURN = "\n";
    private static final String COLON = " : ";
    private static final PrintStream CONSOLE = System.out;

    private OutputView() {
    }

    public static void print(LadderGame ladderGame) {
        List<String> players = collectPlayerString(ladderGame);
        List<String> prizes = collectPrizeString(ladderGame);
        int maxLength = checkMaxLength(players, prizes);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(makeSpacing(players, maxLength));
        stringBuilder.append(drawLadder(ladderGame.getLadder(), maxLength));
        stringBuilder.append(makeSpacing(prizes, maxLength));

        CONSOLE.println(stringBuilder.toString());
    }

    public static void print(Map<Player, Prize> allPlayersResult) {
        allPlayersResult.forEach((key, value) ->
                CONSOLE.println(key.getName() + COLON + value.getPrize()));
    }

    private static List<String> collectPlayerString(LadderGame ladderGame) {
        return ladderGame.getPlayers()
                .getPlayers()
                .stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    private static List<String> collectPrizeString(LadderGame ladderGame) {
        return ladderGame.getPrizes()
                .getPrizes()
                .stream()
                .map(Prize::getPrize)
                .collect(Collectors.toList());
    }

    private static String drawLadder(Ladder ladder, int maxLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LadderLine ladderLine : ladder.getLadder()) {
            stringBuilder.append(drawTillMaxLength(BLANK_MARKER, maxLength));
            stringBuilder.append(drawLadderLine(ladderLine, maxLength));
        }
        return stringBuilder.append(CARRIAGE_RETURN).toString();
    }

    private static String drawLadderLine(LadderLine ladderLine, int maxLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Point point : ladderLine.getPoints()) {
            stringBuilder.append(drawPoint(point, maxLength));
        }
        return stringBuilder.append(CARRIAGE_RETURN).toString();
    }

    private static String drawPoint(Point point, int maxLength) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LADDER_MARKER);
        if (point.getDirection().isRight()) {
            stringBuilder.append(drawTillMaxLength(LINE_MARKER, maxLength));
        }
        if (!point.getDirection().isRight()) {
            stringBuilder.append(drawTillMaxLength(BLANK_MARKER, maxLength));
        }
        return stringBuilder.toString();
    }

    private static String drawTillMaxLength(String marker, int maxLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            stringBuilder.append(marker);
        }
        return stringBuilder.toString();
    }

    private static String makeSpacing(List<String> targets, int maxLength) {
        StringBuilder stringBuilder = new StringBuilder();
        String leftAlignName = targets.get(ZERO);
        stringBuilder.append(String.format("%-" + maxLength + "s ", leftAlignName));

        for (int i = 1; i < targets.size(); i++) {
            String rightAlignName = targets.get(i);
            stringBuilder.append(String.format("%" + maxLength + "s ", rightAlignName));
        }
        return stringBuilder.append(CARRIAGE_RETURN).toString();
    }

    private static int checkMaxLength(List<String> players, List<String> prizes) {
        String maxName = getLongestName(players);
        String maxPrize = getLogiestPrize(prizes);
        return Math.max(maxName.length(), maxPrize.length());
    }

    private static String getLongestName(List<String> players) {
        return players.stream()
                .max(comparing(String::length))
                .orElseThrow(IllegalArgumentException::new);
    }

    private static String getLogiestPrize(List<String> prizes) {
        return prizes.stream()
                .max(comparing(String::length))
                .orElseThrow(IllegalArgumentException::new);
    }

}
