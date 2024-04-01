package laddergame.view;

import laddergame.domain.ladder.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String PLAYER_INPUT_GUIDE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String WINNING_INPUT_GUIDE_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_OF_LADDER_INPUT_GUIDE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행결과";
    private static final String FRAME = "|";
    private static final String STEP = "-----";
    private static final String BLANK_STEP = "     ";
    private static final String BLANK = " ";
    private static final String NEXT_LINE = System.lineSeparator();
    private static final String PLAYER_NAME_FORMAT = "%6s";
    private static final String WINNING_CONTENTS_FORMAT = "%-6s";
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;


    public static void printPlayerInputGuideMessage() {
        System.out.println(PLAYER_INPUT_GUIDE_MESSAGE);
    }

    public static void printWinningInputGuideMessage() {
        String winningsGuidMessage = new StringBuilder()
                .append(NEXT_LINE)
                .append(WINNING_INPUT_GUIDE_MESSAGE)
                .toString();

        System.out.println(winningsGuidMessage);
    }

    public static void printHeightOfLadderGuideMessage() {
        String heightOfLadderGuideMessage = new StringBuilder()
                .append(NEXT_LINE)
                .append(HEIGHT_OF_LADDER_INPUT_GUIDE_MESSAGE)
                .toString();

        System.out.println(heightOfLadderGuideMessage);
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public static void printExecutionResult(Ladder ladder) {
        PlayersAndWinningContents playersAndWinningContents = ladder.playersAndWinningContents();
        int lengthOfFirstPlayerName = playersAndWinningContents.findPlayerByIndex(FIRST_INDEX)
                .lengthOfName();

        String executionResult = new StringBuilder()
                .append(NEXT_LINE)
                .append(EXECUTION_RESULT_MESSAGE)
                .append(NEXT_LINE)
                .append(NEXT_LINE)
                .append(playersMessage(playersAndWinningContents.players()))
                .append(NEXT_LINE)
                .append(ladderMessage(lengthOfFirstPlayerName, ladder))
                .append(NEXT_LINE)
                .append(winningContentsMessage(lengthOfFirstPlayerName, playersAndWinningContents.winningContents()))
                .toString();

        System.out.println(executionResult);
    }

    private static String playersMessage(Players players) {
        return players.players()
                .stream()
                .map(player -> String.format(PLAYER_NAME_FORMAT, player.name()))
                .collect(Collectors.joining())
                .trim();
    }

    private static String ladderMessage(int lengthOfFirstPlayerName, Ladder ladder) {
        return ladder.lines()
                .stream()
                .map(line -> lineMessage(lengthOfFirstPlayerName, line))
                .collect(Collectors.joining(NEXT_LINE));
    }

    private static String winningContentsMessage(int lengthOfFirstPlayerName, WinningContents winningContents) {
        String firstWinningContentFormat = new StringBuilder()
                .append("%-")
                .append(lengthOfFirstPlayerName + 1)
                .append("s")
                .toString();

        String firstWinningContent = winningContents.findWinningContentByIndex(FIRST_INDEX)
                .winningContent();
        StringBuilder winningContentsMessageBuilder = new StringBuilder(String.format(firstWinningContentFormat, firstWinningContent));

        IntStream.range(SECOND_INDEX, winningContents.numberOfWinningContents())
                .forEach(i -> {
                    String winningContent = winningContents.findWinningContentByIndex(i)
                            .winningContent();
                    winningContentsMessageBuilder.append(String.format(WINNING_CONTENTS_FORMAT, winningContent));
                });

        return winningContentsMessageBuilder.toString();
    }

    private static String lineMessage(int lengthOfFirstPlayerName, Line line) {
        String prefixOfLine = new StringBuilder()
                .append(BLANK.repeat(lengthOfFirstPlayerName))
                .append(FRAME)
                .toString();

        return line.links()
                .stream()
                .map(link -> link.isLinked() ? STEP : BLANK_STEP)
                .collect(Collectors.joining(FRAME, prefixOfLine, FRAME));
    }
}
