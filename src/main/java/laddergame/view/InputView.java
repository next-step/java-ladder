package laddergame.view;

import laddergame.util.Parser;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String DELIMITER = ",";

    private InputView() {
    }

    public static List<String> enterPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = SCANNER.nextLine();
        return Parser.parse(input, DELIMITER);
    }

    public static int enterHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }
}
