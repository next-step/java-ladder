package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.Players;
import nextstep.strategy.RandomLineStrategy;
import nextstep.view.Input;
import nextstep.view.Output;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        Players playerNames = Input.getUserName();
        List<String> result = Input.getResult();
        int height = Input.getHeight();

        Ladder ladder = new Ladder(height, playerNames.getPlayersSize(), RandomLineStrategy.getInstance());
        Output.printName(playerNames.getPlayers());
        Output.printLadder(ladder);
    }
}
