package nextstep.ladder.codeleesh.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static List<String> inputParticipationNames() {

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final String name = SCANNER.nextLine();
        validate(name);
        return split(name);
    }

    public static List<String> inputRunningResult() {

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        final String result = SCANNER.nextLine();
        validate(result);
        return split(result);
    }

    private static void validate(final String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("참가자 이름은 필수값입니다.");
        }
    }

    private static List<String> split(final String name) {

        return Arrays.stream(name.split(DELIMITER))
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return Integer.parseInt(SCANNER.next());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    public static String inputResultName() {

        System.out.println("결과를 보고 싶은 사람은?");
        final String name = SCANNER.next();
        validate(name);
        return name;
    }

}
