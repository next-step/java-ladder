package nextstep.ladder.view;

import static nextstep.ladder.view.PrintUtils.*;

import java.util.Scanner;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.PositiveNumber;

public class InputView {

    private static final String JOIN_PARTICIPANTS_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String NUMBER_OF_MAX_LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String SHOW_PARTICIPANT_NAME_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";

    private final Scanner sc = new Scanner(System.in);

    public Participants inputJoinParticipants() {
        print(JOIN_PARTICIPANTS_INPUT_MESSAGE);

        return Participants.create(sc.next());
    }

    public LadderResults inputResults() {
        print(LADDER_RESULT_INPUT_MESSAGE);

        return LadderResults.create(sc.next());
    }

    public PositiveNumber inputLadderHeight() {
        printSpace();
        print(NUMBER_OF_MAX_LADDER_HEIGHT_INPUT_MESSAGE);

        return PositiveNumber.create(sc.nextInt());
    }

    public String inputShowParticipantName() {
        printSpace();
        print(SHOW_PARTICIPANT_NAME_INPUT_MESSAGE);

        return sc.next();
    }

}
