package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String showNamesInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = SCANNER.nextLine();
        System.out.printf("%n");
        return names;
    }

    public static int showLadderHeightInput() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.printf("%n");
        return height;
    }
}
