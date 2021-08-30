package ladder.presentation.input;

import java.util.Scanner;

public class LadderResultInputView {

    private static final String INPUT_COMMENT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    public String input() {
        Scanner sc = new Scanner(System.in);
        System.out.println(INPUT_COMMENT);
        String users = sc.nextLine();
        System.out.println();
        return users;
    }
}
