package nextstep.step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";
    private static final String GET_USER_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GET_LADDER_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";
    private Scanner scanner = new Scanner(System.in);

    public List<String> getUserNames() {
        System.out.println(GET_USER_MSG);
        return Arrays.asList(scanner.nextLine().split(DELIMITER));
    }

    public int getLadderHeight() {
        System.out.println(GET_LADDER_HEIGHT_MSG);
        return scanner.nextInt();
    }
}
