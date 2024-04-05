package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.factory.PlayerFactory;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args){

        List<String> playersNames = InputView.getPlayersNames();
        Players players = PlayerFactory.create(playersNames);

        Integer height = InputView.getLadderHeight();
        Ladder ladder = new Ladder(players, height);

        OutputView.printLadderResult(ladder, players);
    }
}
