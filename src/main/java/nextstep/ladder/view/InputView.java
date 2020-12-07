package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final String INPUT_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final String INPUT_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public String inputParticipants() {
        System.out.println(INPUT_PARTICIPANTS);
        return scanner.nextLine();
    }

    public String inputHeight() {
        System.out.println();
        System.out.println(INPUT_HEIGHT);
        return scanner.nextLine();
    }

    public String inputResults() {
        System.out.println();
        System.out.println(INPUT_RESULTS);
        return scanner.nextLine();
    }
}
