package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGameResults;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.LadderGameView;

public class LadderGame {

    public static void start(LadderGameView view) {
        try {
            Participants participants = new Participants(view.getNames());

            Lines lines = new Lines(view.getHeight(), participants.size());
            LadderGameResults results = new LadderGameResults(view.getRequireResults());

            view.showLines(participants, lines, results.getValue());
        } catch (Exception exception) {
            view.showText(exception.getMessage());
            start(view);
        }
    }
}
