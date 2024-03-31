package view;

import domain.LadderResult;
import domain.Player;
import domain.Players;
import util.StringUtil;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String PLAYER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String MAX_LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    public static final String LADDER_HEIGHT_RANGE_OVER = "1 이상의 정수만 입력할 수 있습니다.";
    public static final String TRY_INPUT_AGAIN = " 다시 입력해주세요.";
    public static final String NUMBER_FORMAT_EXCEPTION = "숫자만 입력할 수 있습니다.";
    public static final String PLAY_RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String GET_PLAYER_RESULT_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";
    public static final String PLAY_RESULT_PRINT_MESSAGE = "실행 결과";
    public static final String ALL_RESULT_REQUEST = "all";
    public static final String EXIT_GAME_INPUT = "exit";
    public static final String EXIT_GAME_MESSAGE = "게임을 종료합니다.";
    public static final String INPUT_DELIMITER = ",";
    public static final int INITIAL_INDEX = 0;
    public static final int MIN_LADDER_HEIGHT = 1;

    public Players inputPlayers() {
        return inputPlayers(PLAYER_NAME_INPUT_MESSAGE);
    }

    private Players inputPlayers(String message) {
        System.out.println(message);
        List<String> nameList = StringUtil.splitStringToList(SCANNER.nextLine(), INPUT_DELIMITER);
        AtomicInteger index = new AtomicInteger(INITIAL_INDEX);
        try {
            List<Player> playerList = nameList.stream()
                    .map(name -> Player.of(name, index.getAndIncrement()))
                    .collect(Collectors.toList());

            return Players.from(playerList);
        } catch (IllegalArgumentException e) {
            return inputPlayers(e.getMessage() + TRY_INPUT_AGAIN);
        }
    }

    public int inputLadderHeight() {
        return inputLadderHeight(MAX_LADDER_HEIGHT_INPUT_MESSAGE);
    }

    private int inputLadderHeight(String message) {
        System.out.println(message);
        try {
            return scanLadderHeight();
        } catch (NumberFormatException e) {
            return inputLadderHeight(NUMBER_FORMAT_EXCEPTION + TRY_INPUT_AGAIN);
        } catch (IllegalArgumentException e) {
            return inputLadderHeight(e.getMessage() + TRY_INPUT_AGAIN);
        }
    }

    private static int scanLadderHeight() {
        int inputInt = Integer.parseInt(SCANNER.nextLine());
        if (inputInt < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(LADDER_HEIGHT_RANGE_OVER + TRY_INPUT_AGAIN);
        }
        return inputInt;
    }

    public List<String> inputResults() {
        return inputResults(PLAY_RESULT_INPUT_MESSAGE);
    }

    private List<String> inputResults(String message) {
        System.out.println(message);
        try {
            return StringUtil.splitStringToList(SCANNER.nextLine(), INPUT_DELIMITER);
        } catch (IllegalArgumentException e) {
            return inputResults(TRY_INPUT_AGAIN);
        }
    }

    public void printPlayerResult(LadderResult ladderResult) {
        printPlayerResult(GET_PLAYER_RESULT_INPUT_MESSAGE, ladderResult);
    }

    private void printPlayerResult(String message, LadderResult ladderResult) {
        System.out.println(message);
        String playerName = SCANNER.nextLine();
        if (playerName.equals(ALL_RESULT_REQUEST)) {
            System.out.println(PLAY_RESULT_PRINT_MESSAGE);
            System.out.println(ladderResult.resultAllToString());
            printPlayerResult(GET_PLAYER_RESULT_INPUT_MESSAGE, ladderResult);
            return;
        }
        if (playerName.equals(EXIT_GAME_INPUT)) {
            System.out.println(EXIT_GAME_MESSAGE);
            return;
        }
        try {
            System.out.println(PLAY_RESULT_PRINT_MESSAGE);
            System.out.println(ladderResult.getResult(playerName));
            printPlayerResult(GET_PLAYER_RESULT_INPUT_MESSAGE, ladderResult);
        } catch (IllegalArgumentException e) {
            printPlayerResult(e.getMessage() + TRY_INPUT_AGAIN, ladderResult);
        }
    }

}
