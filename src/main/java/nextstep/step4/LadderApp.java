package nextstep.step4;


import nextstep.step4.engine.Ladder;
import nextstep.step4.engine.LadderResult;
import nextstep.step4.impl.ResultProcessor;
import nextstep.step4.impl.Height;
import nextstep.step4.impl.Participant;
import nextstep.step4.impl.Participants;
import nextstep.step4.impl.Results;

import static nextstep.step4.factory.LadderFactoryBean.creatorLadderFactory;
import static nextstep.step4.view.InputView.*;
import static nextstep.step4.view.ResultView.print;
import static nextstep.step4.view.ResultView.println;

public class LadderApp {

    public static final String ALL = "ALL";

    public static void main(String[] args) {
        final Participants participants = inputParticipants();
        final Results results = inputResult(participants.countOfPerson());
        final ResultProcessor resultProcessor = new ResultProcessor(participants, results);

        final Height height = inputLadderHeight();

        println(participants.toString());
        final Ladder ladder = creatorLadderFactory().create(participants.countOfPerson(), height.get());
        print(ladder.toString());
        println(results.toString());

        String participantName = inputParticipantLadderResult();

        while(isNotAll(participantName)) {
            final int index = participants.getIndex(new Participant(participantName));
            final LadderResult ladderResult = ladder.play(index);
            print(resultProcessor.toResult(ladderResult));
            participantName = inputParticipantLadderResult();
        }

        print(resultProcessor.toResult(ladder.play()));
    }

    private static boolean isNotAll(String ladderResult) {
        return !ALL.equals(ladderResult);
    }
}
