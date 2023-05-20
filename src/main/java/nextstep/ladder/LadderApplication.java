package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.RandomLinesGenerator;
import nextstep.ladder.domain.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {

        String answerUserNames = InputView.askUserNames();
        String answerResults = InputView.askResults();
        Integer answerheight = InputView.askHeight();

        Results results = Results.toResults(answerResults, answerheight);

        LadderGame ladderGame = new LadderGame(answerUserNames,
                answerheight,
                new RandomLinesGenerator());

        ladderGame.play();

        OutputView.drawLadder(ladderGame, results);
        OutputView.drawResult(ladderGame, results, InputView.askResultUserName());
    }
}
