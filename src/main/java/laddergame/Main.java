package laddergame;

import laddergame.domain.*;
import laddergame.util.Mapper;
import laddergame.util.RandomValueGenerator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Players players = new Players(InputView.enterPlayerNames());
        Results results = new Results(InputView.enterResults());

        Height height = new Height(InputView.enterHeight());
        Width width = new Width(players);

        Ladder ladder = Ladder.create(height, width, new RandomValueGenerator());
        OutputView.printLadder(players, ladder, results);

        players.executeGame(ladder, results);
        Map<Name, Result> totalResult = Mapper.toMap(players);
        while (true) {
            Name name = new Name(InputView.enterNameForShowResult());
            OutputView.printResult(totalResult, name);
        }
    }
}
