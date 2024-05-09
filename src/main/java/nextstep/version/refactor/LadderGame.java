package nextstep.version.refactor;

import nextstep.version.refactor.domain.*;

public class LadderGame {
    public static void main(String[] args) {
        Participants participants = InputView.createParticipants();
        Rewards rewards = InputView.createRewards();

        Ladder ladder = new Ladder(participants.size(), InputView.getHeight(), new RandomCreator());
        OutputView.printLadder(participants, ladder, rewards);

        MatchResult matchResult = ladder.play();
        LadderResult result = matchResult.map(participants, rewards);

        OutputView.printResult(result);
    }
}
