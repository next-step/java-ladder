package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> inputPerson() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static List<String> inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputFinalResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
