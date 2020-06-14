package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String PLAYER_NAME_DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] scanPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String names = scanner.nextLine();

        return names.split(PLAYER_NAME_DELIMITER);
    }
}
