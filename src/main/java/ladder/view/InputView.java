package ladder.view;

import ladder.domain.Player;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private Scanner scanner;

    public InputView() {
        this(System.in);
    }

    public InputView(final InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public Player inputPlayerName() {
        System.out.println(INPUT_PLAYER_NAMES_MESSAGE);
        return new Player(scanner.nextLine());
    }
}
