package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String REGEX = ",";
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> inputUser() {
        System.out.println("참여할 사람 이름을 입력하세요 (쉼표로 구분!)");
        return Arrays.asList(scanner.nextLine().split(REGEX));
    }

    public static List<String> inputResults() {
        System.out.println("실행 결과를 입력하세요! (쉼표로 구분!)");
        if(scanner.nextLine().isEmpty()) {
        }
        return Arrays.asList(scanner.nextLine().split(REGEX));
    }

    public static int inputHeight() {
        System.out.println("사다리 높이는 얼마에요?");
        return scanner.nextInt();
    }

    public static String inputUserResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
