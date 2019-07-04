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

        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        int maxHeight = scanner.nextInt();
        return maxHeight;
    }

    public static String inputUserReward() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputUserReward = scanner.nextLine();
        return inputUserReward;
    }

    public static String requestResult() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n결과를 보고 싶은 사람은?");
        String userName = scanner.nextLine();
        return userName;
    }
}
