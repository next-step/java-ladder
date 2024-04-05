package ladder.view;

import ladder.domain.Participants;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_DELIMITER = ",";

    public static Participants askParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        checkEmptyInput(input);
        return Participants.generateParticipants(input.split(SPLIT_DELIMITER, -1));
    }

    public static int askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    private static void checkEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 값이 입력되었습니다.");
        }
    }
}
