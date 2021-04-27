package step4.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getPlayers() {
        System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int getLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getPrizes() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static String getPlayer() {
        System.out.println("\n\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
