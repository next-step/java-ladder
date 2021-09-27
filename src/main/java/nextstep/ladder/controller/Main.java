package nextstep.ladder.controller;

import nextstep.ladder.model.v1.Label;
import nextstep.ladder.model.v1.Labels;
import nextstep.ladder.model.api.Ladder;
import nextstep.ladder.model.api.LadderBuilder;
import nextstep.ladder.model.v2.LateralLadderBuilder;
import nextstep.ladder.model.v2.RandomLadderPointGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Labels names = new Labels(InputView.readNames());
        Labels results = new Labels(InputView.readResults());

        LadderBuilder builder = new LateralLadderBuilder(new RandomLadderPointGenerator());
        Ladder ladder = builder.build(names.size(), InputView.readHeight());

        OutputView.printLabels(names);
        OutputView.printLadder(ladder);
        OutputView.printLabels(results);

        for (Label currentName = new Label(InputView.readName()); !currentName.isExit(); currentName = new Label(InputView.readName())) {
            if (currentName.isAll()) {
                climbAll(names, results, ladder);
                continue;
            }
            int resultWidth = ladder.climb(names.indexOf(currentName));
            OutputView.printResult(results.at(resultWidth));
        }
    }

    private static void climbAll(Labels names, Labels results, Ladder ladder) {
        List<Label> orderedResults = new ArrayList<>();
        for (Label name : names) {
            int resultWidth = ladder.climb(names.indexOf(name));
            orderedResults.add(results.at(resultWidth));
        }
        OutputView.printResultsWithNames(names, orderedResults);
    }
}
