package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.ladder.LadderDecorator;
import ladder.domain.ladder.line.Line;
import ladder.domain.ladder.point.Point;
import ladder.domain.player.PlayerName;
import ladder.domain.player.PlayerNames;
import ladder.domain.prize.LadderPrize;
import ladder.domain.prize.LadderPrizes;
import ladder.dto.LadderResult;
import ladder.utils.StringUtils;

public class ResultView {

    public static final String NEWLINE = System.lineSeparator();
    public static final String RESULT_HEADER = NEWLINE + "사다리 결과" + NEWLINE;
    public static final String LADDER_RESULT = NEWLINE + "실행 결과";
    public static final String VERTICAL = "|";
    public static final String HORIZONTAL = "-";
    public static final String SPACE = " ";
    public static final int PADDING = 1;

    private ResultView() {
    }

    public static void printLadderResult(int resultIndex, LadderPrizes ladderPrizes) {
        System.out.println(LADDER_RESULT);
        LadderPrize ladderPrize = ladderPrizes.getPrizeByIndex(resultIndex);
        String prize = ladderPrize.getPrize();
        System.out.println(prize);
    }

    public static void printAllResult(LadderResult ladderResult, LadderDecorator ladderDecorator) {
        System.out.println(LADDER_RESULT);
        PlayerNames playerNames = ladderDecorator.getPlayerNames();
        LadderPrizes ladderPrizes = ladderDecorator.getLadderPrizes();
        for (PlayerName playerName : playerNames.getNames()) {
            String name = playerName.getName();
            int nameIndex = playerNames.getIndexByName(name);
            int resultIndex = ladderResult.resultByIndex(nameIndex);
            LadderPrize ladderPrize = ladderPrizes.getPrizeByIndex(resultIndex);
            String prize = ladderPrize.getPrize();
            System.out.println(name + " : " + prize);
        }
    }

    public static void printDecoratedLadder(Ladder ladder, LadderDecorator ladderDecorator) {
        int headerWidth = ladderDecorator.maxLength() + PADDING;
        System.out.println(RESULT_HEADER);
        printPlayerNames(ladderDecorator.getPlayerNames(), headerWidth);
        printLadder(ladder, ladderDecorator.maxLength());
        printLadderPrizes(ladderDecorator.getLadderPrizes(), headerWidth);
    }

    private static void printPlayerNames(PlayerNames playerNames, int width) {
        List<String> names = playerNames.getNames()
                .stream()
                .map(playerName -> spaceString(playerName.getName(), width))
                .collect(Collectors.toList());
        System.out.println(String.join("", names));
    }

    private static void printLadderPrizes(LadderPrizes ladderPrizes, int width) {
        List<String> prizes = ladderPrizes.getPrizes()
                .stream()
                .map(ladderPrize -> spaceString(ladderPrize.getPrize(), width))
                .collect(Collectors.toList());
        String prizeLine = String.join("", prizes);
        System.out.println(prizeLine);
    }

    private static void printLadder(Ladder ladder, int width) {
        List<String> lines = ladder.getLines()
                .stream()
                .map(line -> lineToString(line, width))
                .collect(Collectors.toList());
        String ladderMultiLines = String.join(NEWLINE, lines);
        System.out.println(ladderMultiLines);
    }

    private static String lineToString(Line line, int width) {
        List<String> points = line.getPoints()
                .stream()
                .map(point -> pointToString(point, width))
                .collect(Collectors.toList());
        return String.join(VERTICAL, points) + VERTICAL;
    }

    private static String pointToString(Point point, int width) {
        if (point.getLeg().isLeft()) {
            return StringUtils.repeat(HORIZONTAL, width);
        }
        return StringUtils.repeat(SPACE, width);
    }

    private static String spaceString(String string, int width) {
        String template = String.format("%%%ds", width);
        return String.format(template, string);
    }
}
