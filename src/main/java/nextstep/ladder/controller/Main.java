package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Label;
import nextstep.ladder.model.Labels;
import nextstep.ladder.model.Player;
import nextstep.ladder.model.RandomDrawStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Labels names = new Labels(InputView.readNames());
        Labels results = new Labels(InputView.readResults());

        Ladder ladder = new Ladder(names.size(), InputView.readHeight());

        ladder.drawSteps(new RandomDrawStrategy());

        OutputView.printLabels(names);
        OutputView.printLadders(ladder);
        OutputView.printLabels(results);

        Label name = new Label(InputView.readName());
        while (!InputView.EXIT.equals(name)) {
            Player player = new Player(names.indexOf(name));
            OutputView.printResult(results.at(player.climb(ladder)));
            name = new Label(InputView.readName());
        }
    }
}
