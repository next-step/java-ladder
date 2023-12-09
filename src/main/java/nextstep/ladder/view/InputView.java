package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputNames = scanner.nextLine();

        return inputNames.split(",");
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int inputHeight = Integer.parseInt(scanner.nextLine());

        return inputHeight;
    }

    public static String[] inputAmounts() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputAmounts = scanner.nextLine();

        return inputAmounts.split(",");
    }

    public static String inputPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        String inputPlayer = scanner.nextLine();

        return inputPlayer;
    }
}
