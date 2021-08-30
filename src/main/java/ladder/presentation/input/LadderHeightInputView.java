package ladder.presentation.input;

import java.util.Scanner;

public class LadderHeightInputView {

    private static final String INPUT_COMMENT = "최대 사다리 높이는 몇 개 인가요?";

    public int input() {
        Scanner sc = new Scanner(System.in);
        System.out.println(INPUT_COMMENT);
        int height = sc.nextInt();
        System.out.println();
        return height;
    }

}
