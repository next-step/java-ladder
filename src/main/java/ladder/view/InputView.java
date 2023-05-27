package ladder.view;

import java.util.Scanner;

public class InputView {

    public static void askNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static String nextString() {
        return new Scanner(System.in).nextLine();
    }

    public static void askHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개 인가요?");
    }

    public static int nextInt() {
        return new Scanner(System.in).nextInt();
    }

    public static void askLadderResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

}
