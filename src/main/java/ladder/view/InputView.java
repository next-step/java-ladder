package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String ASK_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final Scanner scanner = new Scanner(System.in);

    public String names() {
        System.out.println(ASK_NAMES);
        return scanner.nextLine();
    }

}
