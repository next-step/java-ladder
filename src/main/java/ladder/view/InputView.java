package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String SPLIT_DELIMITER = ",";

    public static String[] players() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Scanner(System.in).nextLine().split(SPLIT_DELIMITER);
    }
}
