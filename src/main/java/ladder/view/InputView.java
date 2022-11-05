package ladder.view;

import java.util.Scanner;

import static ladder.view.OutputView.show;

public class InputView {

    private static Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String[] scanPlayersName() {
        show("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return SCANNER.nextLine().split(",");
    }

    public static int scanLadderHeight() {
        show("최대 사다리 높이는 몇 개인가요?");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String[] scanLadderResult() {
        show("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        return SCANNER.nextLine().split(",");
    }

    public static String scanPlayerResult() {
        show("결과를 보고 싶은 사람은?");

        return SCANNER.nextLine();
    }

}
