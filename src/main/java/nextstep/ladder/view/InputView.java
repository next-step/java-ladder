package nextstep.ladder.view;

import nextstep.ladder.domain.user.Users;

import java.util.Scanner;

public class InputView {

    private static final String ASK_USER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public Users askUserName() {
        System.out.println(ASK_USER_NAME);
        String input = scanner.nextLine();
        return new Users(input);
    }

    public int askLadderHeight() {
        System.out.println(ASK_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

}
