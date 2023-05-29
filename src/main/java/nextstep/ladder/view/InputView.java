package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String DELIMITER = ",";

    private InputView() {
        throw new AssertionError();
    }

    public static String[] readUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요.(이름은 쉼표(,)로 구분하세요");
        return readString().split(DELIMITER);
    }

    public static String[] readGameResult() {
        System.out.println("실행 결과를 입력하세요.(결과는 쉼표(,)로 구분하세요");
        return readString().split(DELIMITER);
    }

    public static int readLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return readInt();
    }

    static String readString() {
        return scanner.nextLine();
    }

    private static int readInt() {
        return toInt(readString());
    }

    private static int toInt(String number) {
        return Integer.parseInt(number);
    }
}
