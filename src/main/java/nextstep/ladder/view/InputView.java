package nextstep.ladder.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static String COMMA = ",";

    private static Scanner scanner = new Scanner(System.in);

    public static List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return splitByDelimiter(scanner.nextLine());
    }

    private static List<String> splitByDelimiter(String names) {
        return Arrays.asList(names.split(COMMA));
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = 0;
        while (true) {
            try {
                height = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력이 가능합니다.");
                System.out.println("최대 사다리 높이는 몇 개인가요?");
                scanner = new Scanner(System.in);
            }
        }
        return height;
    }
}
