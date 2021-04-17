package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.PrizeMapper;
import nextstep.ladder.domain.Prizes;
import nextstep.ladder.view.InputView;

import static nextstep.ladder.Controller.*;

public class Main {
    public static void main(String[] args) {
        List<String> info = InputView.getInfoFromClient();

        Players players = createPlayers(Arrays.asList(info.get(0).split(",")));
        Prizes prizes =  createPrizes(Arrays.asList(info.get(1).split(",")));
        PrizeMapper prizeMapper = createPrizeMapper(prizes, players);
        LadderGame game = createGame(players, Integer.parseInt(info.get(2)));

        printLadderResult(game);
        printPrizeResult(prizes);
        printGameResult(InputView.getPlayerResult(), prizeMapper);
    }
}
