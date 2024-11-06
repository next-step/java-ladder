package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAMES_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요";
    private static final String INPUT_RESULT_MSG = "실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요";
    private static final String INPUT_RESULT_TARGET_MSG = "결과를 보고 싶은 사람은?";

    private static final String INPUT_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_ERR_MSG = "참여부 수 만큼 결과를 입력하세요";

    public static String[] inputPlayers() {
        return inputTarget(INPUT_NAMES_MSG);
    }

    public static String[] inputResults(int size) {

        String[] results = inputTarget(INPUT_RESULT_MSG);
        if (results.length != size) {
            OutputView.printMsg(INPUT_ERR_MSG);
            results = inputResults(size);
        }
        return results;
    }

    public static String inputSearchTarget() {
        OutputView.printMsg(INPUT_RESULT_TARGET_MSG);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private static String[] inputTarget(String msg) {
        OutputView.printMsg(msg);
        Scanner scanner = new Scanner(System.in);
        return scanner.useDelimiter(",").nextLine().split(",");
    }

    public static int inputHeight() {
        OutputView.printMsg(INPUT_HEIGHT_MSG);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
