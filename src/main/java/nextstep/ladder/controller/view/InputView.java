package nextstep.ladder.controller.view;

import nextstep.ladder.utils.Parser;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return nextLine();
    }

    public static String getGifts() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return nextLine();
    }

    public static int getHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return nextInt();
    }

    public static String getTarget() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return nextLine();
    }

    private static int nextInt() {
        return Parser.parseInt(nextLine());
    }

    private static String nextLine() {
        return SCANNER.nextLine();
    }
}
