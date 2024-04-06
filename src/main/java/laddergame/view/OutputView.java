package laddergame.view;

import laddergame.domain.Players;
import laddergame.domain.PlayersAndWinningContents;
import laddergame.domain.ResultOfLadder;
import laddergame.domain.WinningContents;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Line;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static laddergame.view.InputView.enteredPlayerForResult;

public class OutputView {
    private static final String PLAYER_INPUT_GUIDE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String WINNING_INPUT_GUIDE_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_OF_LADDER_INPUT_GUIDE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String PLAYER_FOR_RESULT_INPUT_GUIDE_MESSAGE = "결과를 보고 싶은 사람은?(종료를 입력하면 프로그램이 종료됩니다.)";
    private static final String END_LADDER_KEYWORD = "종료";
    private static final String EXECUTION_RESULT_MESSAGE = "실행결과";
    private static final String LADDER_COLUMN = "|";
    private static final String LINKED = "-----";
    private static final String UNLINKED = "     ";
    private static final String BLANK = " ";
    private static final String COLON_BETWEEN_BLANK = " : ";
    private static final String NEXT_LINE = System.lineSeparator();
    private static final String PLAYER_NAME_FORMAT = "%6s";
    private static final String WINNING_CONTENTS_FORMAT = "%-6s";
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    private OutputView() {
    }

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

    public static void printPlayerForResultInputGuideMessage() {
        String playerForResultInputGuideMessage = new StringBuilder()
                .append(NEXT_LINE)
                .append(PLAYER_FOR_RESULT_INPUT_GUIDE_MESSAGE)
                .toString();

        System.out.println(playerForResultInputGuideMessage);
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

    public static void printLadderResult(PlayersAndWinningContents playersAndWinningContents, Ladder ladder) {
        int lengthOfFirstPlayerName = playersAndWinningContents.findPlayerByIndex(FIRST_INDEX)
                .lengthOfName();

        String ladderResult = new StringBuilder()
                .append(NEXT_LINE)
                .append(LADDER_RESULT_MESSAGE)
                .append(NEXT_LINE)
                .append(NEXT_LINE)
                .append(playersMessage(playersAndWinningContents.players()))
                .append(NEXT_LINE)
                .append(ladderMessage(lengthOfFirstPlayerName, ladder))
                .append(NEXT_LINE)
                .append(winningContentsMessage(lengthOfFirstPlayerName, playersAndWinningContents.winningContents()))
                .toString();

        System.out.println(ladderResult);
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
                .append(LADDER_COLUMN)
                .toString();

        return line.links()
                .stream()
                .map(link -> link.isLinked() ? LINKED : UNLINKED)
                .collect(Collectors.joining(LADDER_COLUMN, prefixOfLine, LADDER_COLUMN));
    }

    public static void printExecutionResult(PlayersAndWinningContents playersAndWinningContents, ResultOfLadder resultOfLadder) {
        while (true) {
            String playerName = enteredPlayerForResult();

            if (playerName.equals(END_LADDER_KEYWORD)) {
                break;
            }

            String executionResult = new StringBuilder()
                    .append(NEXT_LINE)
                    .append(EXECUTION_RESULT_MESSAGE)
                    .append(executionResultMessage(playersAndWinningContents, playerName, resultOfLadder))
                    .toString();

            System.out.println(executionResult);
        }
    }

    private static String executionResultMessage(PlayersAndWinningContents playersAndWinningContents, String playerName, ResultOfLadder resultOfLadder) {
        StringBuilder executionResultMessageBuilder = new StringBuilder();

        playersAndWinningContents.findPlayersByName(playerName).forEach(player ->
                executionResultMessageBuilder.append(NEXT_LINE)
                        .append(player.name())
                        .append(COLON_BETWEEN_BLANK)
                        .append(resultOfLadder.winningContentOfPlayer(player))
        );

        return executionResultMessageBuilder.toString();
    }
}
