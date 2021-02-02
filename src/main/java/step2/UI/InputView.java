package step2.UI;

import java.util.Scanner;

public class InputView {

    private static final String PLAYER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "사다리 높이는 몇칸 인가요?";
    private static final String RESULT_NAME_INPUT_MESSAGE = "실행결과를 입력하세요. (쉼표(,)로 구분하세요)";

    public static String inputPlayerName() {
        System.out.println(PLAYER_NAME_INPUT_MESSAGE);

        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println(LADDER_HEIGHT_MESSAGE);

        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }

    public static String inputResultName() {
        System.out.println(RESULT_NAME_INPUT_MESSAGE);

        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }
}
