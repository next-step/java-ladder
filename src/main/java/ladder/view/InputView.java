package ladder.view;

import ladder.domain.LadderGameSetting;
import ladder.domain.LadderGameInfo;
import ladder.domain.Persons;
import ladder.domain.Prizes;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_PRIZES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAX_LADDER = "최대 사다리 높이는 몇 개 인가요?";
    private static final String INPUT_RESULT_NAME = "결과를 보고 싶은 사람은?";

    public static String inputPersons() {
        System.out.println(INPUT_PLAYERS_NAME);
        return scanner.next();
    }

    public static String inputPrizes() {
        System.out.println(INPUT_PRIZES);
        return scanner.next();
    }

    public static int inputHeight() {
        System.out.println(INPUT_MAX_LADDER);
        return scanner.nextInt();
    }

    public static LadderGameInfo inputParameters() {
        String persons = inputPersons();
        String prizes = inputPrizes();
        int ladderHeight = inputHeight();
        LadderGameSetting ladderGameSetting = LadderGameSetting.of(Persons.of(persons),
                                                            Prizes.of(prizes));

        return new LadderGameInfo(ladderGameSetting, ladderHeight);
    }

    public static String inputResult() {
        System.out.println(INPUT_RESULT_NAME);
        return scanner.next();
    }
}
