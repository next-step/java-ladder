package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAXIMUM_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private String inputStringValue() {
        return scanner.nextLine();
    }

    private int inputIntValue() {
        int intValue = scanner.nextInt();
        scanner.nextLine();
        return intValue;
    }

    public List<String> inputParticipantsName() {
        System.out.println(INPUT_PARTICIPANTS_NAME);

        List<String> names = extractNames();
        validateNames(names);

        return names;
    }

    public int inputMaximumHeight() {
        System.out.println("\n" + INPUT_MAXIMUM_HEIGHT);
        return inputIntValue();
    }

    private void validateNames(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("사람이름을 적어도 2명 이상 입력해야 합니다.");
        }

        if (names.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("사람 이름이 5자를 넘었습니다.");
        }
    }

    private List<String> extractNames() {
        List<String> names = Arrays.stream(inputStringValue().split(","))
            .map(String::trim)
            .collect(Collectors.toList());
        return names;
    }

    public void scannerClose() {
        scanner.close();
    }
}
