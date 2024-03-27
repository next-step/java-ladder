package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> names = InputView.readParticipantNames();
        int height = InputView.readLadderMaxHeight();

        Participants participants = Participants.of(names);
        Ladder ladder = Ladder.of(participants.numberOf(), height);
        LadderGame ladderGame = new LadderGame(participants, ladder);

        ResultView.printGameResult(ladderGame);
    }

}
