package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UsersInputView extends AbstractView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String USER_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String DELIMITER = ",";

    public static List<String> getUserInput() {
        stringBuilder.append(USER_INPUT_MESSAGE);
        printAndClear();

        String usersInput = scanner.nextLine();

        return Arrays.asList(usersInput.split(DELIMITER))
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

}
