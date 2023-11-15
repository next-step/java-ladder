package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.factory.LadderFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LadderController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        ResultView resultView = new ResultView();

        List<String> names = inputView.inputNames();
        int height = inputView.inputHeight();

        Ladder ladder = LadderFactory.create(names, height, () -> new Random().nextBoolean());

        resultView.result(ladder);
    }
}
