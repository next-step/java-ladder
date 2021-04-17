package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.PrizeMapper;
import nextstep.ladder.domain.Prizes;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Controller {
    public static void main(String[] args) {
        List<String> info = InputView.getInfoFromClient();

        Players players = new Players(Arrays.asList(info.get(0).split(",")));
        LadderGame ladderGame = new LadderGame(players, Integer.parseInt(info.get(2)));
        Prizes prizes = new Prizes(Arrays.asList(info.get(1).split(",")));

        ResultView.printObjectsName(ladderGame.getAllPlayerNames());
        ResultView.printLadderResult(ladderGame.build(), players.getPlayerCount());
        ResultView.printObjectsName(prizes.getAllPrizesName());
        ladderGame.start();

        String input = InputView.getPlayerResult();
        PrizeMapper prizeMapper = new PrizeMapper(prizes, players);
        ResultView.printResultList(prizeMapper.getPlayerPrizeResult(input));
    }
}
