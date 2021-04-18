package ladder.view;

import java.util.Scanner;

import static java.lang.Integer.valueOf;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_PARTICIPANTS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_PERSON_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String REGEX = ",";

    private static class InputViewHolder {
        private static final InputView instance = new InputView();
    }

    private InputView() {
    }

    public static final InputView getInstance() {
        return InputViewHolder.instance;
    }

    public final String[] inputParticipantsByClient() {
        System.out.println(INPUT_PARTICIPANTS_MESSAGE);
        return SCANNER.nextLine().split(REGEX);
    }

    public final String[] inputLadderResultsByClient() {
        System.out.println(INPUT_LADDER_RESULTS_MESSAGE);
        return SCANNER.nextLine().split(REGEX);
    }

    public final int inputLadderHeightByClient() {
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        return valueOf(SCANNER.nextLine());
    }

    public final String inputResultPersonByClient() {
        System.out.println(INPUT_RESULT_PERSON_MESSAGE);
        return SCANNER.nextLine();
    }




}
