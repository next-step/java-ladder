package laddergame;

import laddergame.domain.Player;
import laddergame.domain.Players;
import laddergame.domain.Result;
import laddergame.domain.Results;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Size;
import laddergame.util.RandomValueGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Players players = new Players(InputView.enterPlayerNames());
        Results results = new Results(InputView.enterResults());

        Size size = Size.calculate(InputView.enterHeight(), players);
        Ladder ladder = Ladder.create(size, new RandomValueGenerator());
        OutputView.printLadder(players, ladder, results);

        Map<Player, Result> totalResult = findResult(players, results, rideLadder(size, ladder));
        while (true) {
            Player player = new Player(InputView.enterNameForShowResult());
            OutputView.printResult(totalResult, player);
        }
    }

    private static List<Integer> rideLadder(Size size, Ladder ladder) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size.width(); i++) {
            result.add(ladder.ride(i));
        }
        return result;
    }

    private static Map<Player, Result> findResult(Players players, Results results, List<Integer> result) {
        Map<Player, Result> map = new HashMap<>();
        for (int i = 0; i < result.size(); i++) {
            map.put(players.getPlayers().get(i), results.getResults().get(result.get(i)));
        }
        return map;
    }
}


