package ladder.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private static String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public static String inputNames() {
        System.out.println(INPUT_NAMES);
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);
        return scanner.nextInt();
    }
}

