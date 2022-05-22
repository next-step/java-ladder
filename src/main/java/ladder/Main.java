package ladder;

import ladder.domain.Height;
import ladder.domain.LadderGame;
import ladder.domain.People;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {
        People people = InputView.participantsNameView();
        Height height = InputView.ladderHeightView();

        LadderGame ladderGame = new LadderGame(people, height);
        ResultView.ladderResultView(ladderGame);
    }
}
