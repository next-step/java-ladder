package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.Ladder.createLadder;
import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.ResultView.*;

public class LadderGame {
    private static final String ALL_PLAYERS = "all";
    private static final int COUNT_OF_SHOWING_RESULT = 2;
    private List<Player> players;
    private List<String> prizes;
    private int heightOfLadder;
    private Ladder ladder;

    public void play() {
        ready();

        makeLadder();
        showLadder();
        playLadder();

        showResultMultiple(COUNT_OF_SHOWING_RESULT);
    }

    private void ready() {
        registerPlayers();
        decidePrizes();
        decideHeightOfLadder();
    }

    private void registerPlayers() {
        players = inputPlayerNames().stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private void decidePrizes() {
        List<String> prizes = inputPrizes();

        if (prizes.size() != players.size()) {
            throw new IllegalArgumentException("상품 수와 참가자 수가 일치하지 않습니다.");
        }

        this.prizes = prizes;
    }

    private void decideHeightOfLadder() {
        heightOfLadder = inputHeightOfLadder();
    }

    private void makeLadder() {
        ladder = createLadder(heightOfLadder, players.size());
    }

    private void showLadder() {
        printPlayers(players);
        printLadder(ladder);
        printPrizes(prizes);
    }

    private void playLadder() {
        List<Integer> result = ladder.play();
        IntStream.range(0, players.size())
                .forEach(i -> players.get(i)
                        .receivePrize(prizes.get(result.get(i))));
    }

    private void showResultMultiple(int count) {
        IntStream.range(0, count)
                .forEach(i -> showResult());
    }

    private void showResult() {
        String targetOfResult = inputTargetForResult();

        if (Objects.equals(targetOfResult, ALL_PLAYERS)) {
            showAllOfResults();
            return;
        }

        showOneOfResult(targetOfResult);
    }

    private void showAllOfResults() {
        printResultTitle();
        players.forEach(player -> printPrizeWithPlayer(player.getName(), player.getPrize()));
    }

    private void showOneOfResult(String playerName) {
        printResultTitle();
        Optional<Player> awardee = players.stream()
                .filter(player -> player.isMatchedName(playerName))
                .findFirst();

        if (awardee.isEmpty()) {
            throw new IllegalArgumentException("참가자 이름을 잘못 입력했습니다.");
        }

        printPrize(awardee.get()
                .getPrize());
    }
}
