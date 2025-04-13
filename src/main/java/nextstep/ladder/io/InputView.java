package nextstep.ladder.io;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String inputLine() {
        return SCANNER.nextLine();
    }

    public static Integer inputHeight() {
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다.");
            throw e;
        }
    }
}
