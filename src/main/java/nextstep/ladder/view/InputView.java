package nextstep.ladder.view;

import static nextstep.ladder.view.PrintUtils.*;

import java.util.Scanner;
import nextstep.ladder.domain.Participants;

public class InputView {

    private static final String JOIN_PARTICIPANTS_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String NUMBER_OF_MAX_LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private final Scanner sc = new Scanner(System.in);

    public Participants inputJoinParticipants() {
        print(JOIN_PARTICIPANTS_INPUT_MESSAGE);

        return Participants.create(sc.next());
    }

    public int inputLadderHeight() {
        printSpace();
        print(NUMBER_OF_MAX_LADDER_HEIGHT_INPUT_MESSAGE);

        return sc.nextInt();
    }


}
