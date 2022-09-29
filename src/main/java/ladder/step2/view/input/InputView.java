package ladder.step2.view.input;

import ladder.step2.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    private static final String PLAYER_NAMES_INPUT_FORM = "[a-zA-Z]{1,5}(,[a-zA-Z]{1,5})*";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    
    public static List<Player> inputPlayerNames() {
        try {
            return inputPlayerNames(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayerNames();
        }
    }
    
    public static List<Player> inputPlayerNames(String playerNames) {
        playerNames = deleteSpace(playerNames);
        checkInputForm(playerNames);
        return getPlayers(playerNames);
    }
    
    private static List<Player> getPlayers(String playerNames) {
        return Arrays.stream(playerNames.split(DELIMITER))
                .map(Player::new)
                .collect(Collectors.toList());
    }
    
    private static void checkInputForm(String playerNames) {
        Matcher matcher = Pattern.compile(PLAYER_NAMES_INPUT_FORM).matcher(playerNames);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    private static String deleteSpace(String playerNames) {
        return playerNames.replace(SPACE, EMPTY);
    }
}
