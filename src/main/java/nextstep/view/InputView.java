package nextstep.view;

import nextstep.util.StringParser;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputUserNames() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)%n",
                StringParser.DELIMINATOR);
        return StringParser.split(SCANNER.nextLine());
    }

    public static List<String> inputLadderResult() {
        System.out.printf("%n실행 결과를 입력하세요. (이름은 쉼표(%s)로 구분하세요)%n",
                StringParser.DELIMINATOR);
        return StringParser.split(SCANNER.nextLine());
    }

    public static int inputLadderHeightMax() {
        try {
            System.out.printf("%n최대 사다리 높이는 몇 개인가요?%n");
            int number = SCANNER.nextInt();

            validatePositiveNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력 가능합니다");
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("자연수만 입력할 수 있습니다.");
        }
    }

    public static String inputUsernameForResult() {
        SCANNER.nextLine();
        System.out.printf("%n결과를 보고 싶은 사람은?%n");
        return SCANNER.next();
    }
}
