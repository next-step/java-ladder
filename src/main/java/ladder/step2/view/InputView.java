package ladder.step2.view;

import ladder.step2.domain.Players;
import ladder.step2.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PLAYER_NAMES_INPUT_MESSAGE = "\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    private static final String PLAYER_NAMES_INPUT_FORM = "[a-zA-Z]{1,5}(,\\s?[a-zA-Z]{1,5})*";
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String DELIMITER = ",";
    
    public static Players inputPlayerNames() {
        try {
            System.out.println(PLAYER_NAMES_INPUT_MESSAGE);
            return inputPlayerNames(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayerNames();
        }
    }
    
    public static Players inputPlayerNames(String playerNames) {
        checkBlankException(playerNames);
        checkPlayerNamesInputForm(playerNames);
        return new Players(split(removeSpace(playerNames)));
    }
    
    private static String removeSpace(final String playerNames) {
        return playerNames.replace(SPACE, EMPTY);
    }
    
    private static List<String> split(final String playerNames) {
        return Arrays.stream(playerNames.split(DELIMITER))
                .collect(Collectors.toList());
    }
    
    private static void checkPlayerNamesInputForm(final String playerNames) {
        final Matcher matcher = Pattern.compile(PLAYER_NAMES_INPUT_FORM).matcher(playerNames);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
    
    private static void checkBlankException(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
}
