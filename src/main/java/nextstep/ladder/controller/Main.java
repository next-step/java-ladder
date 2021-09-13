package nextstep.ladder.controller;

import nextstep.ladder.model.Ladders;
import nextstep.ladder.model.Names;
import nextstep.ladder.model.RandomDrawStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Names names = new Names(InputView.readNames());

        Ladders ladders = new Ladders(names.size(), InputView.readHeight());

        ladders.drawSteps(new RandomDrawStrategy());

        OutputView.printNames(names);
        OutputView.printLadders(ladders);
    }
}
