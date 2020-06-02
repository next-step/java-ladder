package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.factory.LadderFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {
        Players players = InputView.getPlayers();
        Height height = InputView.getHeight();

        Ladder ladder = LadderFactory.create(players, height);
        ResultView.printLadder(ladder);
    }
}
