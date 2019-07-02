package nextstep.view;

import java.util.Scanner;

public class Inputview {
    public static String inputUserName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputUserNames = scanner.nextLine();
        return inputUserNames;
    }

    public static int inputLadderMaxHeight() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxHeight = scanner.nextInt();
        return maxHeight;
    }
}
