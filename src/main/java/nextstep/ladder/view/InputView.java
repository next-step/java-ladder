package nextstep.ladder.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String PLAYER_NAME_DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] scanPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String names = scanner.nextLine();

        return names.split(PLAYER_NAME_DELIMITER);
    }

    public static int scanLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        int input;

        try {
            input = scanner.nextInt();
            scanner.nextLine();     // 버퍼에서 개행문자 제거
        } catch(InputMismatchException e) {
            scanner.nextLine();     // 버퍼에서 개행문자 제거
            System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");

            return scanLadderHeight();
        }

        return input;
    }
}
