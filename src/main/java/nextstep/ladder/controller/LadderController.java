package nextstep.ladder.controller;

import nextstep.ladder.domain.Category;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.service.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.StringAsCategory;
import nextstep.ladder.domain.StringAsHeight;
import nextstep.ladder.domain.StringAsPlayers;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.PlayersResultView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        String playerName = InputView.inputPlayerName();
        Players players = new StringAsPlayers(playerName).players();

        String items = InputView.inputCategory();
        Category category = new StringAsCategory(items).category(players);

        String ladderLength = InputView.inputLadderLength();
        Height height = new StringAsHeight(ladderLength).height();

        Ladder ladder = Ladder.of(players.width(), height);
        ResultView.outputResult(players, ladder, category);

        LadderGame ladderGame = LadderGame.getInstance();
        PlayersResultView.gameResult(ladderGame.gamePlay(players, ladder, category));
    }

}
