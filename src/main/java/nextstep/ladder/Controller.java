package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Controller {
    public static void main(String[] args) {
        List<String> info = InputView.getInfoFromClient();

        Players players = new Players(Arrays.asList(info.get(0).split(",")));
        Ladder ladder = new Ladder(Integer.parseInt(info.get(1)), players.getPlayerCount());

        ResultView.printPlayersName(players.getAllPlayerNames());
        ResultView.printResult(ladder.build(), players.getPlayerCount());
    }
}
