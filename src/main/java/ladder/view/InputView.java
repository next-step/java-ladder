package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_USERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_NAME = "결과를 보고 싶은 사람은?";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getUsers() {
        System.out.println(INPUT_USERS);

        return scanner.nextLine();
    }

    public String getLadderResult() {
        System.out.println(INPUT_LADDER_RESULT);

        return scanner.nextLine();
    }


    public String getLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);

        return scanner.nextLine();
    }

    public String getResultUserName() {
        System.out.println(INPUT_RESULT_NAME);

        return scanner.nextLine();
    }
}
