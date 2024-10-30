package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    public static String readNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
