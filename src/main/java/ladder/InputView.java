package ladder;

import java.util.Scanner;

public class InputView {

    private final String INPUT_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private Scanner scanner = new Scanner(System.in);

    public String inputPlayerName() {
        System.out.println(INPUT_PLAYERS_NAME);
        return scanner.nextLine();
    }

    public String inputHeight() {
        System.out.println(INPUT_HEIGHT);
        return scanner.nextLine();
    }
}
