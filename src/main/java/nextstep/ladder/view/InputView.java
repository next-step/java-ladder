package nextstep.ladder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static String user() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int ladderHeight() {

        System.out.println("최대 사다리 높이는 몇 개인가요?");

        try {
            return scanner.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            scanner = new Scanner(System.in);
            System.out.println("최대 사다리 높이는 숫자만 입력 가능합니다.");
            return ladderHeight();
        }
    }
}
