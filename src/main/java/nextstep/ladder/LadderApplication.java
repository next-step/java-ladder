package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.presentation.LadderGameResultView;
import nextstep.ladder.presentation.util.ConsoleInputUtil;

public class LadderApplication {
    public static void main(String[] args) {
        Participants participants = new Participants(participantNames());
        Ladder ladder = ladderFactory().create(participants, maximumLadderHeight());

        LadderGameResultView ladderGameResultView = new LadderGameResultView(participants, ladder);
        ladderGameResultView.printExecuteResult();
    }

    private static LadderFactory ladderFactory() {
        return new LadderFactory(lineFactory());
    }

    private static LineFactory lineFactory() {
        return new LineFactory(randomConnectionsFactory());
    }

    private static ConnectionsFactory randomConnectionsFactory() {
        return new RandomConnectionsFactory();
    }

    private static int maximumLadderHeight() {
        return ConsoleInputUtil.askMaximumLadderHeight();
    }

    private static String participantNames() {
        return ConsoleInputUtil.askParticipantNames();
    }
}
