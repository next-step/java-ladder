package ladder.presentation;

import java.util.Scanner;

public class LadderHeightInputView {

    private static final String LADDER_HEIGHT_INPUT_VIEW_COMMENT = "최대 사다리 높이는 몇 개 인가요?";

    public static int input() {
        Scanner sc = new Scanner(System.in);
        System.out.println(LADDER_HEIGHT_INPUT_VIEW_COMMENT);
        return sc.nextInt();
    }

}
