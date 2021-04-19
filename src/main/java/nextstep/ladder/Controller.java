package nextstep.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.PrizeMapper;
import nextstep.ladder.domain.Prizes;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Controller {
    public void run() {
        List<String> info = InputView.getInfoFromClient();

        Players players = createPlayers(Arrays.asList(info.get(0).split(",")));
        Prizes prizes =  createPrizes(Arrays.asList(info.get(1).split(",")));
        PrizeMapper prizeMapper = createPrizeMapper(prizes, players);
        LadderGame game = createGame(players, Integer.parseInt(info.get(2)));

        printLadderResult(game);
        printPrizeResult(prizes);
        printGameResult(InputView.getPlayerResult(), prizeMapper);
    }

    private Players createPlayers(List<String> playerNames) {
        return new Players(playerNames);
    }

    private Prizes createPrizes(List<String> prizeNames) {
        return new Prizes(prizeNames);
    }

    private LadderGame createGame(Players players, int height) {
        return new LadderGame(players, height);
    }

    private PrizeMapper createPrizeMapper(Prizes prizes, Players players) {
        return new PrizeMapper(prizes, players);
    }

    private void printLadderResult(LadderGame ladderGame) {
        ResultView.printObjectsName(ladderGame.getAllPlayerNames());
        ResultView.printLadderResult(ladderGame.build(), ladderGame.getPlayerCount());
        ladderGame.start();
    }

    private void printPrizeResult(Prizes prizes) {
        ResultView.printObjectsName(prizes.getAllPrizesName());
    }

    private void printGameResult(String input, PrizeMapper prizeMapper) {
        if ("all".equals(input)) {
            ResultView.printResultList(mapperToStringDto(prizeMapper.getAllPlayersPrizes()));
            return;
        }
        ResultView.printResultList(Arrays.asList(prizeMapper.getPrizeByPlayerName(input).toString()));
    }

    private List<String> mapperToStringDto(Map<?, ?> mapper) {
        List<String> keys = mapper.keySet().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        List<String> values = mapper.values().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        List<String> combined = new ArrayList<>();

        IntStream.range(0, mapper.size())
                .forEach(i -> combined.add(keys.get(i) + " : " + values.get(i)));
        return combined;
    }
}
