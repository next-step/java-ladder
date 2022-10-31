package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.Players;
import nextstep.strategy.RandomLineStrategy;
import nextstep.view.Input;
import nextstep.view.Output;

public class LadderApplication {
    public static void main(String[] args) {
        Players playerNames = Input.getUserName();
        int height = Input.getHeight();

        Ladder ladder = new Ladder(height, playerNames.getPlayers().size(), new RandomLineStrategy());
        Output.printName(playerNames.getPlayers());
        Output.printLadder(ladder);
    }
}
