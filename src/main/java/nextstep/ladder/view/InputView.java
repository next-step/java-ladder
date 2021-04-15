package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";

    public List<String> receivePlayerNames() {
        printMessage("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return getListOfString();
    }

    public List<String> receiveRewards() {
        printMessage("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return getListOfString();
    }

    public int receiveLadderHeight() {
        printMessage("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(getUserInput());
    }

    public String receiveNameForSeeingResult() {
        printMessage("결과를 보고 싶은 사람은?");
        return getUserInput();
    }

    private String getUserInput() {
        printMessage(System.lineSeparator());
        Scanner scanner = new Scanner(System.in).useDelimiter(System.lineSeparator() + "|\n");
        return scanner.next();
    }

    private List<String> getListOfString() {
        return Arrays.asList(getUserInput().split(DELIMITER));
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
