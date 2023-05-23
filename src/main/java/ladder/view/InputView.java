package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA_DELIMITER = ",";

    public static String[] enterNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return SCANNER.nextLine().split(COMMA_DELIMITER);
    }

    public static String[] enterResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return SCANNER.nextLine().split(COMMA_DELIMITER);
    }

    public static int enterHeight() {
        System.out.printf("%n최대 사다리 높이는 몇 개인가요?%n");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String enterUserToGetResult() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }

}
