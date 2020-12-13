package nextstep.step4.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private static final String INPUT_USER = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public String getUsers() {
        System.out.println(INPUT_USER);
        return scanner.nextLine();
    }
}
