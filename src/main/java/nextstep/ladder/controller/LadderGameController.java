package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGameResult;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Prize;
import nextstep.ladder.service.LadderGameService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.ResultView.*;

public class LadderGameController {
    public static final String ALL_PLAYERS = "all";
    private final LadderGameService service;

    public LadderGameController(LadderGameService service) {
        this.service = service;
    }

    public List<Player> registerPlayers() {
        return this.service.createPlayers(inputPlayerNames())
                .collect(Collectors.toList());
    }

    public List<Prize> decidePrizes(int countOfPrizes) {
        List<String> prizes = inputPrizes();
        if (prizes.size() != countOfPrizes) {
            throw new IllegalArgumentException("상품 수가 유효하지 않습니다.");
        }

        return this.service.createPrizes(prizes)
                .collect(Collectors.toList());
    }

    public Ladder makeLadder(int countOfPlayer) {
        int height = inputHeightOfLadder();
        return service.createLadder(height, countOfPlayer);
    }

    public void showLadderGame(List<Player> players, Ladder ladder, List<Prize> prizes) {
        printLadderResultTitle();
        printPlayers(players);
        printLadder(ladder);
        printPrizes(prizes);
    }

    public LadderGameResult play(List<Player> players, List<Prize> prizes, Ladder ladder) {
        return service.play(players, prizes, ladder);
    }

    public void searchResultMultiple(LadderGameResult result, int countOfSearch) {
        IntStream.range(0, countOfSearch)
                .forEach(num -> searchResult(result));
    }

    public void searchResult(LadderGameResult result) {
        String target = inputTargetForResult();

        printPlayResultTitle();

        if (Objects.equals(target, ALL_PLAYERS)) {
            printPrizeWithPlayer(result);
            return;
        }

        printPrize(service.getPrizeByPlayer(result, target));
    }
}
