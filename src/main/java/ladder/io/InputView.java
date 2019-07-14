package ladder.io;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return getInt();
    }

    public static String inputPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static String inputStartGame() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    private static int getInt() {
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }
}
