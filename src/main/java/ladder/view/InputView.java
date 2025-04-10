package ladder.view;

import ladder.domain.Height;
import ladder.domain.Player;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String USER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public List<Player> getUsers() {
        System.out.println(USER_NAME_MESSAGE);
        String input = getStringInput();
        return Parser.parseStringToPlayer(input);
    }

    public Height getHeight() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
        int input = getIntegerInput();
        return new Height(input);
    }

    public String getStringInput() {
        String input = scanner.nextLine();
        validateStringInput(input);
        return input;
    }

    public int getIntegerInput() {
        validateIntegerInput();
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    private void validateStringInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 문자열이 Null 이거나 빈 문자열 입니다.");
        }
    }

    private void validateIntegerInput() {
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }
}
