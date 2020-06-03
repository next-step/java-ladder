package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] askingPeopleName() {
        System.out.println("참여할 사람 이름을 입력하세요.");
        return scanner.nextLine().split(",");
    }

    public static int askingLadderMaxHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
