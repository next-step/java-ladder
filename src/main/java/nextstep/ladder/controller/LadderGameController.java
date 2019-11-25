package nextstep.ladder.controller;

import nextstep.ladder.domain.game.Game;
import nextstep.ladder.domain.game.GameResults;
import nextstep.ladder.domain.game.LadderResults;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.view.LadderGameInputView;
import nextstep.ladder.view.LadderGameOutputView;

public class LadderGameController {

    public static void start(LadderGameInputView inputView, LadderGameOutputView outputView) {
        try {
            Participants participants = new Participants(inputView.getNames());
            Lines lines = new Lines(inputView.getHeight(), participants.size());
            LadderResults results = new LadderResults(inputView.getLineResults());

            Game ladderGame = Game.ready(participants, lines, results);
            outputView.showLines(ladderGame);

            GameResults gameResults = ladderGame.play(inputView.getTargetParticipant());
            outputView.showGameResults(gameResults);
        } catch (Exception exception) {
            outputView.showErrorText(exception);
            start(inputView, outputView);
        }
    }
}
