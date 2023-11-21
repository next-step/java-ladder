package ladder.view;

import ladder.domain.Name;
import ladder.domain.Names;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_PRIZES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_PERSON_NAME = "결과를 보고 싶은 사람은?";

    public static Names inputNames() {
        System.out.println(INPUT_NAMES);
        return new Names(Arrays.stream(SCANNER.nextLine().split(","))
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList()));
    }

    public static int inputHeight() {
        System.out.println(INPUT_HEIGHT);
        return SCANNER.nextInt();
    }

    public static List<String> inputPrizes(int size) {
        SCANNER.nextLine();
        System.out.println(INPUT_PRIZES);
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static String inputPersonName() {
        System.out.println();
        System.out.println(INPUT_PERSON_NAME);
        return SCANNER.nextLine();
    }
}
