package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. 쉼표(,)로 구분");
        return getLine();
    }

    public static int inputRowCount() {
        System.out.println("최대 사다리 높이를 입력하세요.");
        return getInt();
    }

    private static int getInt() {
        if (SCANNER.hasNextInt()) {
            return SCANNER.nextInt();
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
