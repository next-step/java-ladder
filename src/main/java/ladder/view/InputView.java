package ladder.view;

import ladder.domain.GamePrize;
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

    public static GamePrize askGamePrize(int countOfPerson) {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        checkEmptyInput(input);

        String[] inputArray = input.split(SPLIT_DELIMITER, -1);
        if (inputArray.length != countOfPerson) {
            throw new IllegalArgumentException("실행 결과의 수는 참가자 수와 동일해야 합니다.");
        }
        return GamePrize.generateGamePrize(inputArray);
    }

    public static int askLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        checkEmptyInput(input);
        return Integer.parseInt(input);
    }

    public static String askParticipantForResult() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        String input = scanner.nextLine();
        checkEmptyInput(input);
        return input;
    }

    private static void checkEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 값이 입력되었습니다.");
        }
    }
}
