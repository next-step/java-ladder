package ladder;

import ladder.domain.Height;
import ladder.domain.LadderGame;
import ladder.domain.Elements;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {
        Elements elements = InputView.participantsNameView();
        Height height = InputView.ladderHeightView();

        LadderGame ladderGame = new LadderGame(elements, height);
        ResultView.ladderResultView(ladderGame);
    }
}
