package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PEOPLE_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final Scanner scanner = new Scanner(System.in);

    public List<String> getPeopleNames() {
        System.out.println(PEOPLE_NAMES_INPUT_MESSAGE);
        String[] peopleNames = scanner.nextLine().split(",");
        System.out.println();
        return Arrays.asList(peopleNames);
    }
}
