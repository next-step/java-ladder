package nextstep.ladder.controller;

import nextstep.ladder.domain.Category;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.InputString;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.service.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.PlayersResultView;
import nextstep.ladder.view.ResultView;

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
