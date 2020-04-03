package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_USERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getUsers() {
        System.out.println(INPUT_USERS);

        return scanner.nextLine();
    }

    public String getLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);

        return scanner.nextLine();
    }
}
