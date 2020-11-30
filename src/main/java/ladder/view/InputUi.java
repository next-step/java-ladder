package ladder.view;

import java.util.Scanner;

public class InputUi {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String nameOfParticipate() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return SCANNER.next();
    }

    public static int maximumHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }

    public static void close() {
        SCANNER.close()
        ;
    }
}
