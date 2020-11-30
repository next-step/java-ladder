package ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INSERT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INSERT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public static String askNames() {
        System.out.println(INSERT_NAMES);
        return scanner.nextLine();
    }
    
    public static int askLadderHeight() {
        System.out.println(INSERT_LADDER_HEIGHT);
        return scanner.nextInt();
    }
}
