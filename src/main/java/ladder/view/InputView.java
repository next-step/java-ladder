package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    private static final String VALID_PARTICIPANTS = "^[a-zA-Z,]*$";
    private static final String COMMA_DELIMITER = ",";

    public List<String> askParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String input = scanner.nextLine();

        while (!isValidParticipants(input)) {
            System.out.println("참여할 사람의 이름을 쉼표로 구분하여 다시 입력해주세요.\n(ex: java,go,lust)");
            input = scanner.nextLine();
        }

        return separateStringByDelimiter(input);
    }

    private boolean isValidParticipants(String input) {
        return input.matches(VALID_PARTICIPANTS);
    }

    private List<String> separateStringByDelimiter(String input) {
        return Arrays.stream(input.split(COMMA_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int askHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        int input = scanner.nextInt();

        while (!isValidHeightOfLadder(input)) {
            System.out.println("사다리의 높이는 0보다 높아야 합니다.\n다시 입력해주세요.");
            input = scanner.nextInt();
        }

        return input;
    }

    private boolean isValidHeightOfLadder(int input) {
        return input > 0;
    }

}
