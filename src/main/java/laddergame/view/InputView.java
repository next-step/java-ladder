package laddergame.view;

import laddergame.domain.HeightOfLadder;
import laddergame.domain.Player;
import laddergame.exception.InvalidHeightOfLadderException;
import laddergame.util.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static laddergame.view.OutputView.printHeightOfLadderGuideMessage;
import static laddergame.view.OutputView.printPlayerInputGuideMessage;

public class InputView {
    private static final String COMMA_DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static List<Player> enteredPlayers() {
        printPlayerInputGuideMessage();

        String nameOfPlayers = SCANNER.nextLine();

        return Arrays.stream(nameOfPlayers.split(COMMA_DELIMITER))
                .map(Player::valueOf)
                .collect(Collectors.toList());
    }

    public static HeightOfLadder enteredHeightOfLadder() {
        printHeightOfLadderGuideMessage();

        String heightInput = SCANNER.nextLine();
        validateHeightInput(heightInput);

        return HeightOfLadder.valueOf(Integer.parseInt(heightInput));
    }

    private static void validateHeightInput(String heightInput) {
        if (!Validator.isPositiveInteger(heightInput)) {
            throw new InvalidHeightOfLadderException(heightInput);
        }
    }
}
