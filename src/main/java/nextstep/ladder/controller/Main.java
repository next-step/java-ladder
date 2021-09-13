package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Label;
import nextstep.ladder.model.Labels;
import nextstep.ladder.model.Player;
import nextstep.ladder.model.RandomDrawStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Labels names = new Labels(InputView.readNames());
        Labels results = new Labels(InputView.readResults());

        Ladder ladder = new Ladder(names.size(), InputView.readHeight());
        ladder.drawSteps(new RandomDrawStrategy());

        OutputView.printLabels(names);
        OutputView.printLadders(ladder);
        OutputView.printLabels(results);

        for (Label currentName = new Label(InputView.readName()); !currentName.isExit(); currentName = new Label(InputView.readName())) {
            if (currentName.isAll()) {
                climbAll(names, results, ladder);
                continue;
            }
            Player player = new Player(names.indexOf(currentName));
            OutputView.printResult(results.at(player.climb(ladder)));
        }
    }

    private static void climbAll(Labels names, Labels results, Ladder ladder) {
        List<Label> orderedResults = new ArrayList<>();
        for (Label name : names) {
            Player player = new Player(names.indexOf(name));
            orderedResults.add(results.at(player.climb(ladder)));
        }
        OutputView.printResultsWithNames(names, orderedResults);
    }
}
