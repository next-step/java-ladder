package laddergame.view;

import laddergame.domain.HeightOfLadder;
import laddergame.domain.Player;
import laddergame.exception.InvalidHeightOfLadderException;
import laddergame.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PLAYER_INPUT_GUIDE_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_OF_LADDER_INPUT_GUIDE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEXT_LINE = System.lineSeparator();
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static List<Player> enteredPlayers() {
        System.out.println(PLAYER_INPUT_GUIDE_MESSAGE);

        String nameOfPlayers = SCANNER.nextLine();

        return Arrays.stream(nameOfPlayers.split(COMMA_DELIMITER))
                .map(Player::valueOf)
                .collect(Collectors.toList());
    }

    public static HeightOfLadder enteredHeightOfLadder() {
        String heightOfLadderGuideMessage = new StringBuilder()
                .append(NEXT_LINE)
                .append(HEIGHT_OF_LADDER_INPUT_GUIDE_MESSAGE)
                .toString();
        System.out.println(heightOfLadderGuideMessage);

        String heightInput = SCANNER.nextLine();
        validateHeightInput(heightInput);

        return HeightOfLadder.valueOf(Integer.parseInt(heightInput));
    }

    private static void validateHeightInput(String heightInput) {
        if(!Validator.isPositiveInteger(heightInput)) {
            throw new InvalidHeightOfLadderException(heightInput);
        }
    }
}
