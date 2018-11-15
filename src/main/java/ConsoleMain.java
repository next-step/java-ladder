import game.ladder.domain.Participant;
import game.ladder.view.InputView;

import java.util.List;

public class ConsoleMain {

    public static void main(String[] args) {
        // TODO 참여자 입력
        List<Participant> participants = InputView.readParticipant();

        // TODO 사다리 높이 입력
        int height = InputView.readHeight();

        // TODO 사다리 만들기


        // TODO 사다리 출력
    }

}
