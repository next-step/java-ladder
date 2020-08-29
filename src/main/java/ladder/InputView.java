package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAMES_PHRASE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_WIDTH_PHRASE = "최대 사다리 높이는 몇 개인가요?";
    private static final String NAME_DELIMITER = ",";
    private static final String BLANK_STRING = " ";
    private static final String EMPTY_STRING = "";

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> getUserNames() {
        System.out.println(INPUT_NAMES_PHRASE);
        String userNames = scanner.nextLine();

        return Arrays.asList(userNames.replaceAll(BLANK_STRING, EMPTY_STRING)
                                      .split(NAME_DELIMITER));
    }

    public int getWidth() {
        System.out.println(LADDER_WIDTH_PHRASE);
        String width = scanner.nextLine();

        return Integer.parseInt(width);
    }

}
