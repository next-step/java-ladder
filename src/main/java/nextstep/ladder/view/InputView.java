package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputPlayerNames() {
        return inputSeparatedString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", ",");
    }

    public static List<String> inputPrizes() {
        return inputSeparatedString("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)", ",");
    }

    public static int inputHeightOfLadder() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");

        return inputNumber();
    }

    public static String inputTargetForResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");

        return scanner.nextLine();
    }

    private static List<String> inputSeparatedString(String guide, String separator) {
        System.out.println(guide);
        String input = scanner.nextLine();

        if (input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(input.split(separator))
                .collect(Collectors.toList());
    }

    private static int inputNumber() {
        int number = scanner.nextInt();
        scanner.nextLine();

        return number;
    }
}
