package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static String GET_USERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String GET_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private final static Scanner scanner = new Scanner(System.in);

    public List<String> getUsers() {
        System.out.println(GET_USERS);
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public int getLadderHeight() {
        System.out.println(GET_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

}
