package nextstep.ladder.view;

import java.util.Scanner;

public class HeightConsoleInput {

    private static final String HEIGHT_QUESTION = "\n최대 사다리 높이는 몇 개인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String askHeight() {
        System.out.println(HEIGHT_QUESTION);
        return scanner.nextLine();
    }
}
