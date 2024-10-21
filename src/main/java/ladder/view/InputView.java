package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import ladder.domain.UserName;

public class InputView {
    private static final String REGEX = ",|, ";
    private static final String INPUT_USERS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final Scanner SCANNER = new Scanner(System.in);

    private static String inputValue() {
        return SCANNER.nextLine();
    }

    public static List<UserName> inputUserNames() {
        System.out.println(INPUT_USERS_MESSAGE);
        return Arrays.stream(inputValue().split(REGEX))
                .map(UserName::new)
                .collect(Collectors.toList());
    }
}
