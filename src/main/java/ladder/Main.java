package ladder;

import ladder.domain.ElementGroup;
import ladder.domain.Height;
import ladder.domain.LadderGame;
import ladder.domain.Elements;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {
        Elements playerElements = InputView.participantsNameView();
        Elements resultElements = InputView.resultView(playerElements);
        Height height = InputView.ladderHeightView();

        LadderGame ladderGame = new LadderGame(new ElementGroup(playerElements, resultElements), height);
        ResultView.ladderResultView(ladderGame);

        ladderGame.start();
    }
}
