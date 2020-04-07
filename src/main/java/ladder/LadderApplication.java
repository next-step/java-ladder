package ladder;

import ladder.domain.LadderGame;
import ladder.service.LadderService;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        LadderService ladderService = new LadderService();

        String names = InputView.inputNames();
        String height = InputView.inputHeight();

        LadderGame game = ladderService.createLadder(names, height);

        ResultView.printPlayers(game.getPlayers());
        ResultView.printLadder(game.getLines());
    }
}
