package nextstep.ladder.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputParticipantsName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(SCANNER.nextLine()
                .split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<String> inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Arrays.stream(SCANNER.nextLine()
                .split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int inputHeight() {
        printBlankLine();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }

    private static void printBlankLine() {
        System.out.println();
    }

    public static String inputResultName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }
}
