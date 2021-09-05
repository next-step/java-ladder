package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private static final String ALL = "all";

    public void play() {
        List<Player> players = InputView.readPlayerName();
        List<PlayingResult> playingResults = InputView.readResult();
        int height = InputView.readHeight();

        Ladder ladder = LadderFactory.create(players.size(), height, new LadderRandomStrategy());

        showLadderGame(players, playingResults, ladder);

        do {
            String matchPlayer = InputView.readMatchPlayer();
            if (matchPlayer.equals(ALL)) {
                matchAll(players, playingResults, ladder);
                return;
            }
            int idx = findIndexFromList(players, matchPlayer);
            matchOne(playingResults, ladder, idx);
        } while (true);
    }

    private void showLadderGame(List<Player> players, List<PlayingResult> playingResults, Ladder ladder) {
        OutputView.printPlayers(players);
        OutputView.printLadder(ladder);
        OutputView.printResultList(playingResults);
    }

    private void matchOne(List<PlayingResult> playingResults, Ladder ladder, int idx) {
        int resultIndex = ladder.moveFrom(idx);
        OutputView.printResult(playingResults.get(resultIndex));
    }

    private void matchAll(List<Player> players, List<PlayingResult> playingResults, Ladder ladder) {
        List<PlayingResult> result = ladder.moveAll().stream()
                .map(playingResults::get)
                .collect(Collectors.toList());

        OutputView.printResult(players, result);
    }

    private int findIndexFromList(List<Player> players, String player) {
        for (int idx = 0; idx < players.size(); idx++) {
            String name = players.get(idx).getName();
            if (player.equals(name)) {
                return idx;
            }
        }
        return -1;
    }

}
