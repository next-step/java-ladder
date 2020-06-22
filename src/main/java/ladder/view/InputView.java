package ladder.view;

import ladder.domain.LadderSetting;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAX_LADDER = "최대 사다리 높이는 몇 개 인가요?";

    public static String inputPersons() {
        System.out.println(INPUT_PLAYERS_NAME);
        return scanner.next();
    }

    public static String inputResults() {
        System.out.println(INPUT_RESULTS);
        return scanner.next();
    }

    public static int inputHeight() {
        System.out.println(INPUT_MAX_LADDER);
        return scanner.nextInt();
    }

    public static LadderSetting inputParameters() {
        String persons = inputPersons();
        String results = inputResults();
        int ladderHeight = inputHeight();

        return new LadderSetting(persons, results, ladderHeight);
    }
}
