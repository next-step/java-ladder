package nextstep.ladder.step4;

import nextstep.ladder.step4.domain.ladder.DefaultLadder;
import nextstep.ladder.step4.domain.ladder.DefaultLadderGenerator;
import nextstep.ladder.step4.domain.ladder.Height;
import nextstep.ladder.step4.domain.ladder.LadderResult;
import nextstep.ladder.step4.domain.player.Category;
import nextstep.ladder.step4.domain.player.Players;
import nextstep.ladder.step4.domain.player.StringAsSplit;
import nextstep.ladder.step4.view.InputView;
import nextstep.ladder.step4.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Players players = Players.of(new StringAsSplit(InputView.players()));
        Category category = Category.of(new StringAsSplit(InputView.category()), players.size());
        Height height = new Height(InputView.height());

        DefaultLadder ladder = new DefaultLadderGenerator(players.size(), height).generate();
        OutputView.ladderResult(players, category, ladder);

        LadderResult ladderResult = ladder.play();
        OutputView.playerResult(players, category, ladderResult);
    }

}
