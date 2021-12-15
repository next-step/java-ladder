package nextstep.ladder.step3.controller;

import nextstep.ladder.step3.domain.Category;
import nextstep.ladder.step3.domain.Height;
import nextstep.ladder.step3.domain.InputString;
import nextstep.ladder.step3.domain.Ladder;
import nextstep.ladder.step3.service.LadderGame;
import nextstep.ladder.step3.domain.Players;
import nextstep.ladder.step3.view.InputView;
import nextstep.ladder.step3.view.PlayersResultView;
import nextstep.ladder.step3.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        InputString inputPlayer = new InputString(InputView.inputPlayers());
        Players players = Players.of(inputPlayer);

        InputString inputCategory = new InputString(InputView.inputCategory());
        Category category = Category.of(inputCategory, players);

        Height height = new Height(InputView.inputHeight());

        Ladder ladder = Ladder.of(players.width(), height);
        ResultView.outputResult(players, ladder, category);

        PlayersResultView.gameResult(LadderGame.gamePlay(players, ladder, category));
    }

}
