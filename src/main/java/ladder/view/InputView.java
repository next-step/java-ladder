package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private final static String QUESTION_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String QUESTION_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {
        //
    }

    public static List<String> getPlayerNames() {
        System.out.println(QUESTION_PLAYER_NAMES);
        String nameInput = scanner.next();
        System.out.println();

        List<String> names = Arrays.stream(nameInput.split(",")).collect(Collectors.toList());
        validateNames(names);

        return names;
    }

    public static int getLadderHeight() {
        System.out.println(QUESTION_LADDER_HEIGHT);
        int ladderHeight = scanner.nextInt();
        System.out.println();

        validateLadderHeight(ladderHeight);

        return ladderHeight;
    }

    public static void validateNames(List<String> names) {
        names.forEach((name) -> {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5글자까지 가능합니다.");
            }
        });
    }

    public static void validateLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException("양수만 가능합니다.");
        }
    }
}
