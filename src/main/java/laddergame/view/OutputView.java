package laddergame.view;

import laddergame.domain.Players;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Line;

import java.util.stream.Collectors;

public class OutputView {
    private static final String PLAYER_INPUT_GUIDE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_OF_LADDER_INPUT_GUIDE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행결과";
    private static final String FRAME = "|";
    private static final String STEP = "-----";
    private static final String BLANK_STEP = "     ";
    private static final String BLANK = " ";
    private static final String NEXT_LINE = System.lineSeparator();
    private static final String PLAYER_NAME_FORMAT = "%6s";
    private static final int FIRST_INDEX = 0;


    public static void printPlayerInputGuideMessage() {
        System.out.println(PLAYER_INPUT_GUIDE_MESSAGE);
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

    public static void printExecutionResult(Players players, Ladder ladder) {
        int lengthOfFirstPlayerName = players.findPlayerByIndex(FIRST_INDEX)
                .lengthOfName();

        String executionResult = new StringBuilder()
                .append(NEXT_LINE)
                .append(EXECUTION_RESULT_MESSAGE)
                .append(NEXT_LINE)
                .append(NEXT_LINE)
                .append(playersMessage(players))
                .append(NEXT_LINE)
                .append(ladderMessage(lengthOfFirstPlayerName, ladder))
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
