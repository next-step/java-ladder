package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ENTER = "\n";

    private InputView() {}

    public static String inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. 쉼표(,)로 구분");
        return getLine();
    }

    public static int inputRowCount() {
        System.out.printf(ENTER);
        System.out.println("최대 사다리 높이를 입력하세요.");
        return getInt();
    }

    public static String inputRewards() {
        System.out.printf(ENTER);
        System.out.println("실행 결과를 입력하세요. 쉼표(,)로 구분");
        return getLine();
    }


    public static String inputResultTarget() {
        System.out.printf(ENTER);
        System.out.println("결과를 보고 싶은 사람은?");
        return getLine();
    }

    private static int getInt() {
        if (SCANNER.hasNextInt()) {
            return Integer.parseInt(SCANNER.nextLine());
        }
        throw new IllegalArgumentException("입력 값이 없거나 숫자형식이 아닙니다.");
    }

    private static String getLine() {
        if (SCANNER.hasNextLine()) {
            return SCANNER.nextLine().trim();
        }
        throw new IllegalArgumentException("입력 값이 없습니다.");
    }
}
