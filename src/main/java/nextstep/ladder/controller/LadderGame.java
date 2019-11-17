package nextstep.ladder.controller;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.LadderGameView;

public class LadderGame {

    public static void start(LadderGameView view) {
        try {
            Participants participants = new Participants(view.getNames());
            int height = view.getHeight();

            Lines lines = new Lines(height, participants.size());
            view.showResult(participants, lines);
        } catch (Exception exception) {
            view.showText(exception.getMessage());
            start(view);
        }
    }
}
