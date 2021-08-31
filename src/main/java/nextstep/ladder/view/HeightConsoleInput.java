package nextstep.ladder.view;

import nextstep.ladder.util.NumberUtils;

import java.util.Scanner;

public class HeightConsoleInput {

    private static final String HEIGHT_QUESTION = "\n최대 사다리 높이는 몇 개인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static int askHeight() {
        System.out.println(HEIGHT_QUESTION);
        return getUntilNumber(scanner.nextLine());
    }

    private static int getUntilNumber(final String height) {
        if (!NumberUtils.isNumber(height)) {
            NumberUtils.printNotNumber(height);
            return askHeight();
        }
        return Integer.parseInt(height);
    }

}
