package ladder.ui;

import java.util.Scanner;
import ladder.domain.LadderHeight;
import ladder.domain.ParticipantInput;

public class InputView {

    private static final String PARTICIPANTS_INPUT_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final String HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static ParticipantInput participantInput() {
        printSource(PARTICIPANTS_INPUT_MSG);
        return new ParticipantInput(SCANNER.nextLine());
    }

    public static LadderHeight heightInput() {
        printSource(HEIGHT_MSG);
        return new LadderHeight(SCANNER.nextInt());
    }

    private static void printSource(String source) {
        System.out.println(source);
    }


}
