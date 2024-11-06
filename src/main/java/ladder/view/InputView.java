package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.util.RandomLineGenerator;
import ladder.exception.InvalidNameException;
import ladder.exception.LineException;
import ladder.exception.PlayersCountException;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_VERTICAL_SIZE_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Players inputNamesToPlayers() {
        try {
            return new Players(inputNames());
        } catch (InvalidNameException e) {
            System.out.println(e.getMessage());
            return inputNamesToPlayers();
        }
    }
    public Ladder inputVerticalSizeToLadder(Players players) {
        try {
            return new Ladder(players, inputVerticalSize(), new RandomLineGenerator());
        } catch (PlayersCountException | LineException e) {
            System.out.println(e.getMessage());
            return inputVerticalSizeToLadder(inputNamesToPlayers());
        }
    }

    private String inputNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    private int inputVerticalSize() {
        System.out.println(INPUT_LADDER_VERTICAL_SIZE_MESSAGE);
        int inputVerticalSize = scanner.nextInt();
        scanner.nextLine();
        return inputVerticalSize;
    }
}
