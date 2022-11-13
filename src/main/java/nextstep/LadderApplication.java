package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.Players;
import nextstep.domain.Result;
import nextstep.strategy.RandomLineStrategy;
import nextstep.view.Input;
import nextstep.view.Output;

public class LadderApplication {
    public static void main(String[] args) {
        Players playerNames = Input.getUserName();
        Result result = new Result(Input.getResult());
        int height = Input.getHeight();

        Ladder ladder = new Ladder(height, playerNames.getPlayersSize(), RandomLineStrategy.getInstance());
        Output.printName(playerNames.getPlayers());
        Output.printLadder(ladder);
        Output.printResult(result);

        Output.printResult(playerNames, result, ladder);
    }
}
