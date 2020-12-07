package nextstep.ladder.view;

import java.util.Scanner;

public class LadderHeightInputView {

    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    public static int enter() {
        System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        return height;
    }
}
