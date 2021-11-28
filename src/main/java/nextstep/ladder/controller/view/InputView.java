package nextstep.ladder.controller.view;

import nextstep.ladder.utils.Parser;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String getNames() {
        println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return getString();
    }

    public static int getHeight() {
        println("\n최대 사다리 높이는 몇 개인가요?");
        return getInt();
    }

    public static String getGifts() {
        println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return getString();
    }

    public static String getTarget() {
        println("\n결과를 보고 싶은 사람은?");
        return getString();
    }

    private static void println(String string) {
        System.out.println(string);
    }

    private static int getInt() {
        return Parser.parseInt(getString());
    }

    private static String getString() {
        return SCANNER.nextLine();
    }

}
