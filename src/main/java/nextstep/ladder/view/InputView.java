package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static void printPersonInput() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void printLadderHeightInput() {
        System.out.println("최대 사다리 높이는 몇 개인가요?.");
    }

    public static int intInput() {
        return scanner.nextInt();
    }

    public static String stringInput() {
        return scanner.next();
    }
}
