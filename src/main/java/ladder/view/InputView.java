package ladder.view;

import java.util.Scanner;

import static java.lang.Integer.valueOf;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_PARTICIPANTS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static class InputViewHolder {
        private static final InputView instance = new InputView();
    }

    private InputView() {
    }

    public static final InputView getInstance() {
        return InputViewHolder.instance;
    }

    public final String inputParticipantsByClient() {
        System.out.println(INPUT_PARTICIPANTS_MESSAGE);
        return SCANNER.nextLine();
    }

    public final int inputLadderHeightByClient() {
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        return valueOf(SCANNER.nextLine());
    }

}
