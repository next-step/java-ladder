package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAMES_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요";
    private static final String INPUT_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";

    public static String[] inputPlayers() {
        OutputView.printMsg(INPUT_NAMES_MSG);
        Scanner scanner = new Scanner(System.in);
        return scanner.useDelimiter(",").nextLine().split(",");
    }

    public static int inputHeight() {
        OutputView.printMsg(INPUT_HEIGHT_MSG);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
