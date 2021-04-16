package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Controller {
    public static void main(String[] args) {
        List<String> info = InputView.getInfoFromClient();

        LadderGame ladderGame = new LadderGame(
                Arrays.asList(info.get(0).split(",")), Integer.parseInt(info.get(1)));

        ResultView.printPlayersName(ladderGame.getAllPlayerNames());
        ResultView.printResult(ladderGame.build(), ladderGame.getPlayerCount());
    }
}
