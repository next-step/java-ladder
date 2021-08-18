package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String MSG_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MSG_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_SPLIT_KEYWORD = ",";

    static final Scanner scanner = new Scanner(System.in);

    public List<String> names(){
        System.out.println(MSG_NAMES);
        String input = scanner.next();
        return Arrays.asList(input.split(NAME_SPLIT_KEYWORD));
    }

    public int height(){
        System.out.println(MSG_HEIGHT);
        return scanner.nextInt();
    }
}
