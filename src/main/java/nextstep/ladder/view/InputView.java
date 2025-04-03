package nextstep.ladder.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String namesInput = SCANNER.nextLine();
        return parseNames(namesInput);
    }

    private static List<String> parseNames(String namesInput) {
        return Arrays.stream(namesInput.split(","))
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputNum();
    }

    public static int inputNum() {
        try {
            int num = SCANNER.nextInt();
            SCANNER.nextLine();
            return num;
        } catch (InputMismatchException e) {
            throw new RuntimeException("정수 숫자만 가능합니다.");
        }
    }

}
