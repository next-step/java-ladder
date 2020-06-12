package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String USERNAME_DELIMITER = ",";

    private InputView() {
    }

    public static List<String> askParticipantsName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String users = SCANNER.nextLine();

        return Arrays.stream(users.split(USERNAME_DELIMITER))
                .collect(Collectors.toList());
    }

    public static int askMaximumLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }
}

