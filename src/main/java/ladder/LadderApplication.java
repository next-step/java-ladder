package ladder;

import ladder.domain.LadderGame;
import ladder.service.LadderService;
import ladder.view.LadderResultDto;
import ladder.view.ResultView;

import java.util.Map;

import static ladder.view.InputView.*;

public class LadderApplication {

    public static void main(String[] args) {
        LadderService ladderService = new LadderService();

        String names = inputNames();
        String prize = inputGamePrize();
        String height = inputHeight();

        LadderGame game = ladderService.createLadderGame(names, height, prize);

        ResultView.printPlayers(game.getPlayers());
        ResultView.printLadder(game.getLadder().getLines());

        while (true) {
            String who = inputWhoseResult();
            Map<String, String> gameResult = ladderService.startGameOfPlayer(who, game);
            LadderResultDto ladderResultDto = new LadderResultDto();
            ladderResultDto.setResult(gameResult);
            ResultView.printLadderResult(ladderResultDto);
        }
    }
}
