package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);


    public static String readUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요.(이름은 쉼표(,)로 구분하세요");
        return readString();
    }

    public static int readLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return readInt();
    }

    private static String readString() {
        return scanner.nextLine();
    }

    private static int readInt() {
        return toInt(readString());
    }

    private static int toInt(String number) {
        return Integer.parseInt(number);
    }
}
