package ladder.step2.view.input;

import ladder.step2.domain.Player;
import ladder.step2.domain.PlayerName;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PLAYER_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    private static final String PLAYER_NAMES_INPUT_FORM = "[a-zA-Z]{1,5}(,\\s?[a-zA-Z]{1,5})*";
    private static final String LADDER_HEIGHT_INPUT_FORM = "[1-9][0-9]*";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    
    public static List<Player> inputPlayerNames() {
        try {
            System.out.println(PLAYER_NAMES_INPUT_MESSAGE);
            return inputPlayerNames(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayerNames();
        }
    }
    
    public static List<Player> inputPlayerNames(String playerNames) {
        checkAllPlayerNamesInputExceptionCase(playerNames);
        return getPlayers(deleteSpace(playerNames));
    }
    
    private static String deleteSpace(String playerNames) {
        return playerNames.replace(SPACE, EMPTY);
    }
    
    private static List<Player> getPlayers(String playerNames) {
        return Arrays.stream(playerNames.split(DELIMITER))
                .map(PlayerName::new)
                .map(Player::new)
                .collect(Collectors.toList());
    }
    
    private static void checkAllPlayerNamesInputExceptionCase(String playerNames) {
        checkNull(playerNames);
        checkPlayerNamesInputForm(playerNames);
    }
    
    private static void checkNull(String playerNames) {
        if (playerNames == null) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    private static void checkPlayerNamesInputForm(String playerNames) {
        Matcher matcher = Pattern.compile(PLAYER_NAMES_INPUT_FORM).matcher(playerNames);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    public static int inputLadderHeight() {
        try {
            System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);
            return inputLadderHeight(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLadderHeight();
        }
    }
    
    public static int inputLadderHeight(String ladderHeight) {
        checkAllLadderHeightInputExceptionCase(ladderHeight);
        return Integer.parseInt(ladderHeight);
    }
    
    private static void checkAllLadderHeightInputExceptionCase(String ladderHeight) {
        checkNull(ladderHeight);
        checkLadderHeightInputForm(ladderHeight);
    }
    
    private static void checkLadderHeightInputForm(String ladderHeight) {
        Matcher matcher = Pattern.compile(LADDER_HEIGHT_INPUT_FORM).matcher(ladderHeight);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
}
