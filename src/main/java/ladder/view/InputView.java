package ladder.view;

import java.util.Scanner;

public class InputView {
    public static String plzEnterUserNames() {
        Printer.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static int plzEnterLadderHeight() {
        Printer.printNewLine();
        Printer.println("최대 사다리 높이는 몇 개인가요?");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
