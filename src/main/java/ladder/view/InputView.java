package ladder.view;

import ladder.util.SplitString;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private InputView() {
    }

    public static List<String> requestJoinMembers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return SplitString.splitString(scanner.nextLine());
    }

    public static List<String> requestResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        return SplitString.splitString(scanner.nextLine());
    }

    public static int requestTotalLines() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        try {
            int totalLines = scanner.nextInt();
            scanner.nextLine();
            return totalLines;
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public static String requestResultGamer() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
