package nextstep.ladder;

import java.util.List;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.PrizeMapper;
import nextstep.ladder.domain.Prizes;
import nextstep.ladder.view.ResultView;

public class Controller {
    public static Players createPlayers(List<String> playerNames) {
        return new Players(playerNames);
    }

    public static Prizes createPrizes(List<String> prizeNames) {
        return new Prizes(prizeNames);
    }

    public static LadderGame createGame(Players players, int height) {
        return new LadderGame(players, height);
    }

    public static PrizeMapper createPrizeMapper(Prizes prizes, Players players) {
        return new PrizeMapper(prizes, players);
    }

    public static void printLadderResult(LadderGame ladderGame) {
        ResultView.printObjectsName(ladderGame.getAllPlayerNames());
        ResultView.printLadderResult(ladderGame.build(), ladderGame.getPlayerCount());
        ladderGame.start();
    }

    public static void printPrizeResult(Prizes prizes) {
        ResultView.printObjectsName(prizes.getAllPrizesName());
    }

    public static void printGameResult(String input, PrizeMapper prizeMapper) {
        ResultView.printResultList(prizeMapper.getPlayerPrizeResult(input));
    }
}
