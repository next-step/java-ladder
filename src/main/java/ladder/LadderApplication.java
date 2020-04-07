package ladder;

import ladder.domain.LadderGame;
import ladder.domain.Node;
import ladder.service.LadderService;
import ladder.view.ResultView;

import static ladder.view.InputView.*;

public class LadderApplication {

    public static void main(String[] args) {
        LadderService ladderService = new LadderService();

        String names = inputNames();
        String result = inputGameResult();
        String height = inputHeight();

        LadderGame game = ladderService.createLadder(names, height, result);

        ResultView.printPlayers(game.getPlayers());
        ResultView.printLadder(game.getLines());

        String who = inputWhoseResult();
        Node node = ladderService.startGameOfPlayer(who, game);

    }
}
