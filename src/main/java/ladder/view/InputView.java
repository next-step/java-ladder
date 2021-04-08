package ladder.view;

import java.util.Scanner;

public class InputView implements BaseView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PERSON_SEPARATOR = ",";

    public String[] inputPersonNames() {
        printlnMessage("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] personNames = scanner.nextLine().split(PERSON_SEPARATOR);
        return personNames;
    }
}
