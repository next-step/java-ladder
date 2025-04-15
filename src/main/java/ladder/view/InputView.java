package ladder.view;

import ladder.domain.Height;
import ladder.domain.Player;
import ladder.domain.Result;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_NAME_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String WANT_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private final Scanner scanner = new Scanner(System.in);

    public List<Player> getPlayers() {
        System.out.println(PLAYER_NAME_MESSAGE);
        String input = getStringInput();
        return Parser.parseStringToPlayer(input);
    }

    public Height getHeight() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
        int input = getIntegerInput();
        return new Height(input);
    }

    public List<Result> getResults() {
        System.out.println(RESULT_NAME_MESSAGE);
        String input = getStringInput();
        return Parser.parseStringToResult(input);
    }

    public String getWantResult() {
        System.out.println();
        System.out.println(WANT_RESULT_MESSAGE);
        return getStringInput();
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
