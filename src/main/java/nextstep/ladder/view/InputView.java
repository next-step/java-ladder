package nextstep.ladder.view;

import nextstep.ladder.model.LadderResults;
import nextstep.ladder.model.Participants;
import nextstep.ladder.model.value.Height;

import java.util.Scanner;

public class InputView {

    private static final String JOIN_PARTICIPANTS_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String NUMBER_OF_MAX_LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_RESULTS_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_RESULTS_SHOW_PERSON = "결과를 보고 싶은 사람은?";
    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static Participants inputJoinParticipants() {
        System.out.println(JOIN_PARTICIPANTS_INPUT_MESSAGE);

        return Participants.from(sc.nextLine());
    }

    public static LadderResults inputLadderResults() {
        System.out.println(LADDER_RESULTS_MESSAGE);

        return LadderResults.of(sc.nextLine());
    }

    public static Height inputLadderHeight() {
        System.out.println(NUMBER_OF_MAX_LADDER_HEIGHT_INPUT_MESSAGE);

        return new Height(sc.nextLine());
    }

    public static String wantShowPerson() {
        System.out.println();
        System.out.println(LADDER_RESULTS_SHOW_PERSON);

        return sc.nextLine();
    }
}
