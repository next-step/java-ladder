package ladder.view;

import ladder.domain.Height;
import ladder.domain.Players;
import ladder.domain.Prizes;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_EXPECT_VALUES_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private Scanner scanner;

    public InputView() {
        this(System.in);
    }

    public InputView(final InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public Players inputPlayerName() {
        System.out.println(INPUT_PLAYER_NAMES_MESSAGE);
        return new Players(scanner.nextLine());
    }

    public Prizes inputPrizes(int playerCount) {
        System.out.println(INPUT_EXPECT_VALUES_MESSAGE);
        return new Prizes(scanner.nextLine(), playerCount);
    }

    public Height inputHeight() {
        System.out.println();
        System.out.println(INPUT_HEIGHT_MESSAGE);
        return Height.of(scanner.nextLine());
    }
}
