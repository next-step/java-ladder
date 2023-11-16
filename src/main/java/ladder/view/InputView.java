package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String ASK_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String COMMA = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public List<String> names() {
        System.out.println(ASK_NAMES);
        return List.of(scanner.nextLine().split(COMMA));
    }

    public int ladderHeight() {
        System.out.println(ASK_LADDER_HEIGHT);
        return scanner.nextInt();
    }

}
