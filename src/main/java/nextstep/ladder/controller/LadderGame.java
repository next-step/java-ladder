package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGameResults;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.LadderGameView;

import java.util.List;

public class LadderGame {

    public static void start(LadderGameView view) {
        try {
            Participants participants = new Participants(view.getNames());

            Lines lines = new Lines(view.getHeight(), participants.size());
            LadderGameResults results = new LadderGameResults(view.getRequireResults());
            view.showLines(participants.getValue(), lines.getValue(), results.getValue());

            List<Integer> startMovePositions = participants.getPositions(view.getTargetParticipant());
            view.showGameResults(participants.getValue(), results.getValue(), lines.move(startMovePositions));
        } catch (Exception exception) {
            view.showText(exception.getMessage());
            start(view);
        }
    }
}
