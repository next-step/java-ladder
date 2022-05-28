package nextstep.ladder;

import nextstep.ladder.doman.LadderGame;
import nextstep.ladder.doman.Participants;
import nextstep.ladder.doman.RandomConnectStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Application {

    public static void main(String args[]) {
        Participants participants = new Participants(InputView.getParticipantNames());
        LadderGame ladderGame = new LadderGame(participants, InputView.getLadderHeight(), new RandomConnectStrategy());

        OutputView.printExecuteMessage();
        OutputView.printPersons(participants);
        OutputView.printResult(ladderGame);
    }

}
