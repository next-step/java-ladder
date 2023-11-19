package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.PlayerResults;
import nextstep.ladder.dto.LadderInformation;
import nextstep.ladder.factory.LadderFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LadderController {

    private static final String ALL = "all";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        ResultView resultView = new ResultView();

        List<String> names = inputView.inputNames();
        List<String> result = inputView.inputResult();
        int height = inputView.inputHeight();
        LadderInformation ladderInformation = new LadderInformation(names.size(), height);

        Ladder ladder = LadderFactory.create(ladderInformation, () -> new Random().nextBoolean());
        PlayerResults playerResults = new PlayerResults(Names.from(names), ladder, result);

        resultView.printLadder(Names.from(names), ladder, result);

        LadderResult ladderResult = new LadderResult(playerResults, ladder);

        while (true) {
            String name = inputView.inputName();
            resultView.result(ladderResult, name);
            if (ALL.equals(name)) {
                break;
            }
        }
    }
}
