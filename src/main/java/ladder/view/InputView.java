package ladder.view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static String getParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return sc.nextLine();
    }

    public static int getHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return sc.nextInt();
    }

    public static String getResultInput() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String selectParticipants() {
        System.out.println("결과를 보고 싶은 사람은?");

        sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
