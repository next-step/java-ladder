package nextstep.step4;


import nextstep.step4.engine.Ladder;
import nextstep.step4.engine.LadderResult;
import nextstep.step4.impl.Height;
import nextstep.step4.engine.Participants;
import nextstep.step4.engine.Results;

import static nextstep.step4.factory.LadderFactoryBean.creatorLadderFactory;
import static nextstep.step4.view.InputView.*;
import static nextstep.step4.view.ResultView.print;
import static nextstep.step4.view.ResultView.println;

public class LadderApp {
    public static final String ALL = "all";

    public static void main(String[] args) {
        final Participants participants = inputParticipants();
        final Results results = inputResult(participants.size());
        final Height height = inputLadderHeight();

        println(participants.toString());
        final Ladder ladder = creatorLadderFactory().create(participants.size(), height.get());
        print(ladder.toString());
        println(results.toString());

        final LadderResult ladderResult = ladder.play(participants, results);

        String participantName = null;
        do {
            participantName = inputParticipantLadderResult();
            print(ladderResult.result(participantName));

        } while (isNotAll(participantName));

        println(ladderResult.toString());
    }

    private static boolean isNotAll(String ladderResult) {
        return !ALL.equals(ladderResult);
    }
}
