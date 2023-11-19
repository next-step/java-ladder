package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public static String inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 5자이하며 쉼표(,)로 구분하세요)");
        return new InputView().scanner.nextLine();
    }

    public static Integer inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new InputView().scanner.nextInt();
    }
}
