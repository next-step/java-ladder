package view;

import domain.Ladder;
import domain.LadderResult;
import domain.Players;
import domain.Point;

import java.util.List;

public class OutputView {
    private static final String TRUE_LINE = "-----|";
    private static final String FALSE_LINE = "     |";
    public static final String PLAY_RESULT_PRINT_MESSAGE = "실행 결과";
    public static final String ALL_RESULT_REQUEST = "all";
    public static final String EXIT_GAME_INPUT = "exit";
    public static final String EXIT_GAME_MESSAGE = "게임을 종료합니다.";
    public static final String GET_PLAYER_RESULT_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printGetPlayerResultInputMessage() {
        System.out.println(GET_PLAYER_RESULT_INPUT_MESSAGE);
    }
    public static void printPlayerResult(String playerName, LadderResult ladderResult) {
        System.out.println(PLAY_RESULT_PRINT_MESSAGE);
        if (playerName.equals(ALL_RESULT_REQUEST)) {
            System.out.println(ladderResult.resultAllToString());
            return;
        }
        System.out.println(ladderResult.getResult(playerName));
    }

    public static boolean isGameExitMessage (String message) {
        if (EXIT_GAME_INPUT.equalsIgnoreCase(message)) {
            System.out.println(EXIT_GAME_MESSAGE);
            return true;
        }
        return false;
    }

    public void printPlayers(Players players) {
        System.out.println(players);
    }

    public void printLadder(Ladder ladder) {
        ladder
            .forEach(line -> {
                StringBuilder sb = new StringBuilder();
                sb.append("|");
                line.forEach(point-> appendLineByPoint(point, sb));
                System.out.println(sb);
            });
    }

    public void printResults(List<String> results) {
        results.forEach(result -> System.out.print(result + Players.PRINT_SPACE));
        System.out.println();
    }

    private void appendLineByPoint(Point point, StringBuilder sb) {
        if (point.isLast()) {
            return;
        }
        if (point.hasCurrent()) {
            sb.append(TRUE_LINE);
            return;
        }
        sb.append(FALSE_LINE);
    }
}
