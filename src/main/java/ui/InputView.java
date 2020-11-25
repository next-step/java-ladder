package ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INSERT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public static String askNames() {
        System.out.println(INSERT_NAMES);
        return scanner.nextLine();
    }
}
