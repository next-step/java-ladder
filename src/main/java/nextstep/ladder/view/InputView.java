package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static String inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int input = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return input;
    }

    public static String inputPlayerNameToCheckResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        String name = scanner.nextLine();
        System.out.println();
        return name;
    }
}
