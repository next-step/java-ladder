package view;

import domain.Player;
import domain.Players;
import util.StringUtil;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String PLAYER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String MAX_LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    public static final String LADDER_HEIGHT_RANGE_OVER = "1 이상의 정수만 입력할 수 있습니다.";
    public static final String TRY_INPUT_AGAIN = " 다시 입력해주세요.";
    public static final String NUMBER_FORMAT_EXCEPTION = "숫자만 입력할 수 있습니다.";

    public Players inputPlayers() {
        return inputPlayers(PLAYER_NAME_INPUT_MESSAGE);
    }

    private Players inputPlayers(String message) {
        System.out.println(message);
        List<String> nameList = StringUtil.splitStringToList(SCANNER.nextLine(), ",");
        try {
            List<Player> playerList = nameList.stream()
                    .map(Player::from)
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
        if (inputInt < 1) {
            throw new IllegalArgumentException(LADDER_HEIGHT_RANGE_OVER + TRY_INPUT_AGAIN);
        }
        return inputInt;
    }

}
