package ladder.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static String joinUser() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼포(,)로 구분하세요)");
        return scanner.next();
    }

    public static int ladderHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return scanner.nextInt();
    }
}
