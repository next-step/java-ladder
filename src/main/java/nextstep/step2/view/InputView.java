package nextstep.step2.view;

import nextstep.step2.domain.People;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputHeight() {
        print("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static People inputNames() {
        print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new People(scanner.next());
    }
    private static void print(String message) {
        System.out.println(message);
    }

}
