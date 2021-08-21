package ladder.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public String receivePlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public int receiveLadderHeight() {
        String input;
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        do {
            input = scanner.nextLine();
        } while (!isNumber(input));
        return Integer.parseInt(input);
    }

    private boolean isNumber(String input) {
        if (input == null || !input.chars().allMatch(Character::isDigit)) {
            System.out.println("숫자만 입력 가능합니다.");
            return false;
        }
        return true;
    }
}
