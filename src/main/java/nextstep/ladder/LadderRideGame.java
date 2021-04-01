package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.service.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.Objects;

public class LadderRideGame {

    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Participants participants = checkUsers(inputView.inputParticipants());
        Height height = checkHeight(inputView.inputLadderHeight());

        Ladder ladder = Ladder.valueOf(participants, height);

        resultView.printResult(ladder, participants);
    }

    private Height checkHeight(int inputLadderHeight) {
        return Height.valueOf(inputLadderHeight);
    }

    private Participants checkUsers(String inputParticipants) {
        if(Objects.isNull(inputParticipants) || inputParticipants.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        return Participants.valueOf(inputParticipants);
    }

}
