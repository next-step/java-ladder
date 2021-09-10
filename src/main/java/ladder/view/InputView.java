package ladder.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public String receivePlayerNames() {
        return receive("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public String receivePlayResults() {
        return receive("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
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

    public String receiveWantedPlayerName() {
        return receive("결과를 보고 싶은 사람은?");
    }

    private String receive(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
