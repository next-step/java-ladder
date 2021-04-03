package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";

    public List<String> receivePlayerNames() {
        printMessage("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.asList(getUserInput().split(DELIMITER));
    }

    public int receiveLadderHeight() {
        printMessage("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(getUserInput());
    }

    private String getUserInput() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        return scanner.next();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
